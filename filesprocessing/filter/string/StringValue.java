package filesprocessing.filter.string;

import filesprocessing.filter.Filter;

import java.nio.file.attribute.FileAttribute;

/**
 * This class is an abstract class that represent objects that knows to filter files and the filter way is
 * getting string value as input
 */
public abstract class StringValue implements Filter {

	protected String value;

	/**
	 * This constructor creates filter with a string value to compare as data member
	 * @param str the string value
	 */
	public StringValue(String str){
		value = str;
	}
}
