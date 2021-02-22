package filesprocessing.filter.string;

import java.io.File;

/**
 * This class is an object with Filter ability that extends StringValue. It checks if file is executable.
 */
public class Executable extends StringValue {

	/**
	 * This constructor creates filter with a string value to compare as data member
	 * @param str the string value
	 */
	public Executable(String str) {
		super(str);
	}

	/**
	 * This method checks if the file is executable
	 * @param file a file to test
	 * @return true if file is pass the test
	 */
	@Override
	public boolean isPass(File file) {
		if (value.equals("YES")){
			return file.canExecute();
		}
		return !file.canExecute();
	}
}
