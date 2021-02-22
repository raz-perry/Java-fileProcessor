package filesprocessing.filter.size;

import java.io.File;

/**
 * This class is an object with Filter ability that extends sizeFilters. It checks if file size is greater
 * than the input number.
 */
public class Greater extends SizeFilters {

	/**
	 * This constructor creates filter with a number to compare as data member
	 * @param n the number
	 */
	public Greater(double n) {
		super(n);
	}

	/**
	 * This method checks if the input file size is greater than the number data member.
	 * @param file a file to test
	 * @return true if file is pass the test
	 */
	@Override
	public boolean isPass(File file) {
		return file.length() > number*CONVERT;
	}
}
