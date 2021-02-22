package filesprocessing;

/**
 * Called when commands file has a mistake but the program should keep running with default arguments.
 */
public class WarningExceptions extends Exception{

	private static final String MSG = "Warning in line ";

	@Override
	public String getMessage() {
		return MSG;
	}
}
