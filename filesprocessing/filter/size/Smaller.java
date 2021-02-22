package filesprocessing.filter.size;

import java.io.File;

/**
 * This class is an object with Filter ability that extends sizeFilters. It checks if file size is smaller
 * than the input number.
 */
public class Smaller extends SizeFilters {

	/**
	 * This constructor creates filter with a number to compare as data member
	 * @param n the number
	 */
	public Smaller(double n) {
		super(n);
	}

	/**
	 * This method checks if the input file size is smaller than the number data member.
	 * @param file a file to test
	 * @return true if file is pass the test
	 */
	@Override
	public boolean isPass(File file) {
		return file.length() < number*CONVERT;
	}
}
