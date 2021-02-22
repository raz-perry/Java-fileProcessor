package filesprocessing.parser;

/**
 * Called when filter sub-section isn't valid
 */
public class FilterException extends ParserExceptions {
	private static final String NAME = "FILTER";

	@Override
	public String toString() {
		return NAME;
	}
}
