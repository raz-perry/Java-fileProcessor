package filesprocessing.filter;

/**
 * enum class for the filterFactory class
 */
public enum Types {
	GREATER_THAN("greater_than"), BETWEEN("between"), SMALLER_THAN("smaller_than"), FILE("file"),
	CONTAINS("contains"), PREFIX("prefix"), SUFFIX("suffix"), WRITABLE("writable"), EXECUTABLE("executable"),
	HIDDEN("hidden"), ALL("all");

	private final String name;
	Types(String str){
		name = str;
	}

	@Override
	public String toString() {
		return name;
	}
}
