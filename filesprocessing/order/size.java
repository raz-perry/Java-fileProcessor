package filesprocessing.order;

import filesprocessing.ToolBox;
import filesprocessing.order.comparators.SortBySize;

import java.io.File;
import java.util.LinkedList;

/**
 * This class is an object with order ability. It is sorting by size, using SortBySize comparator and
 * ToolBox.mergeSort static method
 */
public class size implements Order{
	@Override
	public LinkedList<File> sort(LinkedList<File> files) {
		ToolBox.mergeSort(files, files.size(), new SortBySize());
		return files;
	}
}
