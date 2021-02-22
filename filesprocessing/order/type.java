package filesprocessing.order;

import filesprocessing.ToolBox;
import filesprocessing.order.comparators.SortByType;

import java.io.File;
import java.util.LinkedList;

/**
 * This class is an object with order ability. It is sorting by type, using SortByType comparator and
 * ToolBox.mergeSort static method
 */
public class type implements Order{
	@Override
	public LinkedList<File> sort(LinkedList<File> files) {
		ToolBox.mergeSort(files, files.size(), new SortByType());
		return files;
	}
}
