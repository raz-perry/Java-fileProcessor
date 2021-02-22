package filesprocessing.filter;

import filesprocessing.WarningExceptions;
import filesprocessing.filter.size.Between;
import filesprocessing.filter.size.Greater;
import filesprocessing.filter.size.Smaller;
import filesprocessing.filter.string.*;

/**
 * This class is a factory of Filter objects
 */
public class FilterFactory {

	/*
	This method checks if a number is a non-negative and throw exception otherwise
	 */
	private boolean positive(double number) throws WarningExceptions {
		if (number < 0){
			throw new WarningExceptions();
		}
		return true;
	}

	/*
	This method checks if an array is in the wanted length and throw exception otherwise
	 */
	private boolean validLength(String[] arr, int n) throws WarningExceptions {
		if (arr.length != n){
			throw new WarningExceptions();
		}
		return true;
	}

	/*
	This method checks if a value is equal to YES or NO and throw exception otherwise
	 */
	private boolean yesOrNo(String value) throws WarningExceptions {
		if (!value.equals("YES") && !value.equals("NO")){
			throw new WarningExceptions();
		}
		return true;
	}

	/*
	This method checks if the first number is smaller than the second and throw exception otherwise
	 */
	private boolean smallerThan(double a, double b) throws WarningExceptions {
		if (b < a){
			throw new WarningExceptions();
		}
		return true;
	}

	/**
	 * This method creates Order object and returns it.
	 * @param name the filter kind that needed
	 * @param values args of the relevant filter
	 * @param suffix a boolean that said if needed to add the relevant suffix
	 * @return object with Filter abilities (implements Filter interface)
	 * @throws WarningExceptions - catch and handle in the parserFile
	 */
	public Filter getFilter(String name, String[] values, boolean suffix) throws WarningExceptions {
		double a; double b;
		if (name.equals(Types.BETWEEN.toString())){
			if (validLength(values, 2)){
				a = Double.parseDouble(values[0]);
				b = Double.parseDouble(values[1]);
				if (positive(a) && positive(b) && smallerThan(a, b)){
					if (suffix){
						return new DecoratorNot(new Between(a, b));
					}
					else {
						return new Between(a, b);
					}
				}
			}
		}
		else if (name.equals(Types.CONTAINS.toString())){
			if (validLength(values, 1)){
				if (suffix){
					return new DecoratorNot(new Contains(values[0]));
				}
				else {
					return new Contains(values[0]);
				}
			}
		}
		else if (name.equals(Types.EXECUTABLE.toString())){
			if (validLength(values, 1)){
				if (yesOrNo(values[0])){
					if (suffix){
						return new DecoratorNot(new Executable(values[0]));
					}
					else {
						return new Executable(values[0]);
					}
				}
			}
		}
		else if (name.equals(Types.FILE.toString())){
			if (validLength(values, 1)){
				if (suffix){
					return new DecoratorNot(new File(values[0]));
				}
				else {
					return new File(values[0]);
				}
			}
		}
		else if (name.equals(Types.GREATER_THAN.toString())){
			if (validLength(values, 1)){
				a = Double.parseDouble(values[0]);
				if (positive(a)){
					if (suffix){
						return new DecoratorNot(new Greater(a));
					}
					else {
						return new Greater(a);
					}
				}
			}
		}
		else if (name.equals(Types.HIDDEN.toString())){
			if (validLength(values, 1)){
				if (yesOrNo(values[0])){
					if (suffix){
						return new DecoratorNot(new Hidden(values[0]));
					}
					else {
						return new Hidden(values[0]);
					}
				}
			}
		}
		else if (name.equals(Types.PREFIX.toString())){
			if (validLength(values, 1)){
				if (suffix){
					return new DecoratorNot(new Prefix(values[0]));
				}
				else {
					return new Prefix(values[0]);
				}
			}
		}
		else if (name.equals(Types.SMALLER_THAN.toString())){
			if (validLength(values, 1)){
				a = Double.parseDouble(values[0]);
				if (positive(a)){
					if (suffix){
						return new DecoratorNot(new Smaller(a));
					}
					else {
						return new Smaller(a);
					}
				}
			}
		}
		else if (name.equals(Types.SUFFIX.toString())){
			if (validLength(values, 1)){
				if (suffix){
					return new DecoratorNot(new Suffix(values[0]));
				}
				else {
					return new Suffix(values[0]);
				}
			}
		}
		else if (name.equals(Types.WRITABLE.toString())){
			if (validLength(values, 1)){
				if (yesOrNo(values[0])){
					if (suffix){
						return new DecoratorNot(new Writable(values[0]));
					}
					else {
						return new Writable(values[0]);
					}
				}
			}
		}
		else if (name.equals(Types.ALL.toString())){
			if (validLength(values, 1)){
				if (!values[0].equals(""))
					throw new WarningExceptions();
				if (suffix){
					return new DecoratorNot(new All());
				}
				else {
					return new All();
				}
			}
		}
		else {
			throw new WarningExceptions();
		}
		return null;
	}
}
