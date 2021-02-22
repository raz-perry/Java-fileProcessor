package filesprocessing.filter.string;

import java.io.File;

/**
 * This class is an object with Filter ability that extends StringValue. It checks if file name contains
 * the input value.
 */
public class Contains extends StringValue {

	/**
	 * This constructor creates filter with a string value to compare as data member
	 * @param str the string value
	 */
	public Contains(String str) {
		super(str);
	}

	/**
	 * This method checks if the input file name contains the input value.
	 * @param file a file to test
	 * @return true if file is pass the test
	 */
	@Override
	public boolean isPass(File file) {
		return file.getName().contains(value);
	}
}
