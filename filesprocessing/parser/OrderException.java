package filesprocessing.parser;

/**
 * Called when order sub-section isn't valid
 */
public class OrderException extends ParserExceptions{
	private static final String NAME = "ORDER";

	@Override
	public String toString() {
		return NAME;
	}
}
