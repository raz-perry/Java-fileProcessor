package filesprocessing.order.comparators;

import filesprocessing.ToolBox;

import java.io.File;
import java.util.Comparator;

/**
 * This is a comparator that compare files according to their type (extension).
 */
public class SortByType implements Comparator<File> {
	@Override
	public int compare(File f1, File f2) {
		if (ToolBox.getExtension(f1.getName()).equals(ToolBox.getExtension(f2.getName()))){
			SortByAbs c = new SortByAbs();
			return c.compare(f1, f2);
		}
		return ToolBox.getExtension(f1.getName()).compareTo(ToolBox.getExtension(f2.getName()));
	}
}
