package filesprocessing.order;

import filesprocessing.ToolBox;
import filesprocessing.order.comparators.SortByAbs;

import java.io.File;
import java.util.LinkedList;

/**
 * This class is an object with order ability. It is sorting by abs, using SortByAbs comparator and
 * ToolBox.mergeSort static method
 */
public class abs implements Order{

	@Override
	public LinkedList<File> sort(LinkedList<File> files) {
		ToolBox.mergeSort(files, files.size(), new SortByAbs());
		return files;
	}
}
