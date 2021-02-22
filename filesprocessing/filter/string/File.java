package filesprocessing.filter.string;

/**
 * This class is an object with Filter ability that extends StringValue. It checks if file name is equal to
 * the input value.
 */
public class File extends StringValue {

	/**
	 * This constructor creates filter with a string value to compare as data member
	 * @param str the string value
	 */
	public File(String str) {
		super(str);
	}

	/**
	 * This method checks if the input file name is equal to the input value.
	 * @param file a file to test
	 * @return true if file is pass the test
	 */
	@Override
	public boolean isPass(java.io.File file) {
		return value.equals(file.getName());
	}
}
