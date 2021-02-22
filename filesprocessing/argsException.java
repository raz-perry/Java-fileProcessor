package filesprocessing;

import java.io.IOException;

/**
 * Called when args isn't valid
 */
public class argsException extends IOException {
	private static final String MSG = "ERROR: the args isn't valid";

	@Override
	public String getMessage() {
		return MSG;
	}
}
