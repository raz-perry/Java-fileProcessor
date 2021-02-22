package filesprocessing.filter.size;

import java.io.File;

/**
 * This class is an object with Filter ability that extends sizeFilters. It checks if file size is between
 * two input sizes.
 */
public class Between extends SizeFilters {

	private final double secondNumber;

	/**
	 * This constructor creates filter with two numbers to compare as data members
	 * @param a first number
	 * @param b second number
	 */
	public Between(double a, double b){
		super(a);
		secondNumber = b;
	}

	/**
	 * This method checks if the input file size is between the two input sizes.
	 * @param file a file to test
	 * @return true if file is pass the test
	 */
	@Override
	public boolean isPass(File file) {
		return file.length() >= number*CONVERT && file.length()  <= secondNumber*CONVERT;
	}
}
