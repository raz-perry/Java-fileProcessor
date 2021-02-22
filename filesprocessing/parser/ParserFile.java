package filesprocessing.parser;

import filesprocessing.ToolBox;
import filesprocessing.WarningExceptions;
import filesprocessing.filter.All;
import filesprocessing.filter.FilterFactory;
import filesprocessing.order.OrderFactory;
import filesprocessing.order.abs;

import java.io.*;
import java.util.LinkedList;

/**
 * This class parsers the command file according to the exercise information. It is the only part that
 * knows how section look like (by using enum class) and it handled type 1 errors - thrown from factories and
 * catch here to create the default objects.
 */
public class ParserFile {

	private static final String SUFFIX_NOT = "NOT";
	private static final String SUFFIX_REVERSE = "REVERSE";

	/*
	class data members
	 */
	private final BufferedReader bufferedReader;
	private LinkedList<Section> sections;
	private int line = 0;

	/**
	 * This constructor reads the file and create the sections according to the file data (by using
	 * createSections method)
	 * @param fileName file to read
	 * @throws IOException - if there is problems in reading the data or the sections isn't valid (for
	 * example no Filter section at all).
	 */
	public ParserFile(String fileName) throws IOException {
		Reader file = new FileReader(fileName);
		bufferedReader = new BufferedReader(file);
		sections = new LinkedList<>();
		createSections();
	}

	/*
	This method updating the line counter and returning the next row.
	 */
	private String readRow() throws IOException {
		line++;
		return bufferedReader.readLine();
	}

	/**
	 * @return the command file sections
	 */
	public LinkedList<Section> getSections(){
		return sections;
	}

	/*
	This method checks each section validation and create the sections with valid objects (after handling
	warnings from factory).
	 */
	private void createSections() throws IOException {
		FilterFactory filterFactory = new FilterFactory();
		OrderFactory orderFactory = new OrderFactory();
		String row = readRow();
		Section curSection;
		boolean hasSuffix;
		while (row != null){
			/*
			filter sub-section:
			 */
			curSection = new Section();
			if (!row.equals(Types.FILTER.toString())){
				throw new FilterException();
			}
			row = readRow();
			if (row == null){
				throw new OrderException();
			}
			hasSuffix = ToolBox.hasSuffix(row, SUFFIX_NOT);
			String filterName = ToolBox.getName(row);
			String value = ToolBox.getFilterValue(row, hasSuffix);
			String[] values = ToolBox.string2array(value);
			try {
				curSection.setFilter(filterFactory.getFilter(filterName, values, hasSuffix));
			}
			catch (WarningExceptions e){
				curSection.addWarning(e.getMessage() + line);
				curSection.setFilter(new All());
			}
			/*
			order sub-section:
			 */
			row = readRow();
			if (row == null || !row.equals(Types.ORDER.toString())){
				throw new OrderException();
			}
			row = readRow();
			if (row == null){
				curSection.setOrder(new abs());
				sections.add(curSection);
				break;
			}
			if (row.equals(Types.FILTER.toString())){
				curSection.setOrder(new abs());
			}
			else {
				hasSuffix = ToolBox.hasSuffix(row, SUFFIX_REVERSE);
				String orderType = ToolBox.getName(row);
				try {
					curSection.setOrder(orderFactory.getOrder(orderType, hasSuffix));
				}
				catch (WarningExceptions e){
					curSection.addWarning(e.getMessage() + line);
					curSection.setOrder(new abs());
				}
				row = readRow();
			}
			sections.add(curSection);
		}
	}
}
