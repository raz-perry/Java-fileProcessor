package filesprocessing.filter.string;

import java.io.File;

/**
 * This class is an object with Filter ability that extends StringValue. It checks if file is hidden.
 */
public class Hidden extends StringValue {

	/*
	constants
	 */
	private static final char DOT = '.';
	private static final String YES = "YES";

	/**
	 * This constructor creates filter with a string value to compare as data member
	 * @param str the string value
	 */
	public Hidden(String str) {
		super(str);
	}

	/**
	 * This method checks if the file is hidden
	 * @param file a file to test
	 * @return true if file is pass the test
	 */
	@Override
	public boolean isPass(File file) {
		if (value.equals(YES)){
			return isHide(file);
		}
		return !isHide(file);
	}

	private boolean isHide(File f){
		if (f.isHidden() || f.getName().lastIndexOf(DOT)==0){
			return true;
		}
		return false;
	}
}
