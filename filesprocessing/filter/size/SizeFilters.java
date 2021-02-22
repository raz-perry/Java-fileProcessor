package filesprocessing.filter.size;

import filesprocessing.filter.Filter;

/**
 * This class is an abstract class that represent objects that knows to filter files and the filter way is
 * relevant to file size
 */
public abstract class SizeFilters implements Filter{

	protected final int CONVERT = 1024;
	protected final double number;

	/**
	 * This constructor creates filter with a number to compare as data member
	 * @param n the number
	 */
	public SizeFilters(double n){
		number = n;
	}


}
