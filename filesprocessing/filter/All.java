package filesprocessing.filter;

import java.io.File;

/**
 * This class is an object with Filter ability. It doesn't check anything on the input file.
 */
public class All implements Filter {

	/**
	 * This method doesn't check anything
	 * @param file a file to test
	 * @return true if file is pass the test
	 */
	@Override
	public boolean isPass(File file) {
		return true;
	}
}
