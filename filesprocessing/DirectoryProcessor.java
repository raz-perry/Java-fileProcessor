package filesprocessing;

import filesprocessing.filter.Filter;
import filesprocessing.parser.FilterException;
import filesprocessing.parser.OrderException;
import filesprocessing.parser.ParserFile;
import filesprocessing.parser.Section;

import java.io.*;
import java.util.LinkedList;

/**
 * This class is the main driver
 */
public class DirectoryProcessor {
	/*
	constants
	 */
	private static final String ERROR_FILE = "ERROR: wrong file name, doesn't exist";
	private static final String ERROR_IO = "ERROR: can't read the command file";

	/*
	class data members
	 */
	private final String dir;
	private LinkedList<File> files = new LinkedList<File>();

	/**
	 * This constructor save the source directory as data member
	 * @param sourceDir represent a directory
	 */
	public DirectoryProcessor(String sourceDir){
		dir = sourceDir;
	}

	/**
	 * This method creates files list in the directory - only if they are files
	 * @throws argsException - if source directory is a file
	 */
	public void readFiles() throws argsException {
		File folder = new File(dir);
		if (folder.isFile()){
			throw new argsException();
		}
		File[] withDirs = folder.listFiles();
		if (withDirs != null){
			for (File file :
					withDirs) {
				if (file.isFile()) {
					files.add(file);
				}
			}
		}
	}

	/**
	 * This method gets a filter and returns the files that passed the filter
	 * @param filter Filter object to check
	 * @return list of files that passed the filter
	 */
	public LinkedList<File> getFilesAfterFilter(Filter filter){
		LinkedList<File> newList = new LinkedList<File>();
		for (File file :
				files) {
			if (filter.isPass(file)) {
				newList.add(file);
			}
		}
		return newList;
	}

	/**
	 * The main driver
	 * @param args first arg should be source directory and second should be commands file
	 */
	public static void main(String[] args) {
		try	{
			if (args.length != 2){
				throw new argsException();
			}
			DirectoryProcessor processor = new DirectoryProcessor(args[0]);
			processor.readFiles();
			ParserFile actionsFile = new ParserFile(args[1]);
			LinkedList<Section> sections = actionsFile.getSections();
			for (Section section :
					sections) {
				LinkedList<File> filteredFiles = processor.getFilesAfterFilter(section.getFilter());
				LinkedList<File> orderedFiles = section.getOrder().sort(filteredFiles);
				ToolBox.printWarnings(section.getWarnings());
				ToolBox.printFiles(orderedFiles);
			}
		}
		catch (argsException | FilterException | OrderException e1){
			System.err.println(e1.getMessage());
		}
		catch (FileNotFoundException e2){
			System.err.println(ERROR_FILE);
		}
		catch (IOException e4){
			System.err.println(ERROR_IO);
		}
	}
}
