package filesprocessing.filter.string;

import filesprocessing.ToolBox;

import java.io.File;

/**
 * This class is an object with Filter ability that extends StringValue. It checks if the input value is
 * the suffix of the file name.
 */
public class Suffix extends StringValue {

	/**
	 * This constructor creates filter with a string value to compare as data member
	 * @param str the string value
	 */
	public Suffix(String str) {
		super(str);
	}

	/**
	 * This method checks if the input value is the suffix of the file name.
	 * @param file a file to test
	 * @return true if file is pass the test
	 */
	@Override
	public boolean isPass(File file) {
		return file.getName().endsWith(value);
	}
}
