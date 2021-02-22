package filesprocessing.filter;

import java.io.File;

/**
 * This is an interface of objects that knows to filter file - make a test on an input file
 */
public interface Filter {

	/**
	 * This method checks if the input file passes the filter test
	 * @param file a file to test
	 * @return true if file is pass the test
	 */
	boolean isPass(File file);

}
