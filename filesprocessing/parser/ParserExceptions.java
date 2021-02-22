package filesprocessing.parser;

import java.io.IOException;

/**
 * Is supper class of filter and order exceptions. Has instance when both sub-section isn't valid
 */
public class ParserExceptions extends IOException {

	private static final String NAME = "all";
	private static final String ERROR = "ERROR: ";
	private static final String MISSING = " sub-section missing";

	@Override
	public String toString() {
		return NAME;
	}

	@Override
	public String getMessage() {
		return ERROR + this.toString() + MISSING;
	}
}
