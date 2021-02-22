package filesprocessing.order.comparators;

import java.io.File;
import java.util.Comparator;

/**
 * This is a comparator that compare files according to their size
 */
public class SortBySize implements Comparator<File> {
	@Override
	public int compare(File f1, File f2) {
		if (f1.length() == f2.length()){
			SortByAbs c = new SortByAbs();
			return c.compare(f1, f2);
		}
		return Long.compare(f1.length(), f2.length());
	}
}
