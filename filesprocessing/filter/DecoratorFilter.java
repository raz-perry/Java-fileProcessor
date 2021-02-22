package filesprocessing.filter;

import java.io.File;

/**
 * This is an abstract class that represent decorators of objects which implements Filter interface.
 */
public abstract class DecoratorFilter implements Filter {

	/*
	class data members
	 */
	private final Filter filter;

	/**
	 * This constructor save the filter that should be decorate
	 * @param filter a filter to decorate
	 */
	public DecoratorFilter(Filter filter){
		this.filter = filter;
	}

	/**
	 * The before decorate method.
	 * @param file a file to test
	 * @return the method result we want to decorate
	 */
	@Override
	public boolean isPass(File file) {
		return filter.isPass(file);
	}
}
