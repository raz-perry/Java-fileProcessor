package filesprocessing.order;

/**
 * enum class for the orderFactory class
 */
public enum Types {
	ABS("abs"), SIZE("size"), TYPE("type");

	private final String name;
	Types(String str){
		name = str;
	}

	@Override
	public String toString() {
		return name;
	}
}
