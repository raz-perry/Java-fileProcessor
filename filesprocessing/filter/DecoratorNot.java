package filesprocessing.filter;

import java.io.File;

/**
 * This class is a decorator that return the opposite answer from object with filter ability.
 */
public class DecoratorNot extends DecoratorFilter {

	/**
	 * This constructor save the filter that should be decorate
	 * @param filter a filter to decorate
	 */
	public DecoratorNot(Filter filter) {
		super(filter);
	}

	/**
	 * The decorate method
	 * @param file a file to test
	 * @return the opposite of the filter method isPass on the input file
	 */
	@Override
	public boolean isPass(File file) {
		return !super.isPass(file);
	}
}
