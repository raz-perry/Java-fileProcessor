package filesprocessing.order.comparators;

import java.io.File;
import java.util.Comparator;

/**
 * This is a comparator that compare files according to their absolute path
 */
public class SortByAbs implements Comparator<File> {
	@Override
	public int compare(File f1, File f2) {
		return f1.getAbsolutePath().compareTo(f2.getAbsolutePath());
	}
}
