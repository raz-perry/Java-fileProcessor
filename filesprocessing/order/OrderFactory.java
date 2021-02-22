package filesprocessing.order;

import filesprocessing.WarningExceptions;

/**
 * This class is a factory of Order objects
 */
public class OrderFactory {

	/**
	 * This method creates Order object and returns it.
	 * @param name the order kind that needed
	 * @param suffix a boolean that said if needed to add the relevant suffix
	 * @return object with Order abilities (implements Order interface)
	 * @throws WarningExceptions - catch and handle in the parserFile
	 */
	public Order getOrder(String name, boolean suffix) throws WarningExceptions {
		if (name.equals(Types.ABS.toString())){
			if (suffix){
				return new DecoratorReverse(new abs());
			}
			else {
				return new abs();
			}
		}
		else if (name.equals(Types.SIZE.toString())){
			if (suffix){
				return new DecoratorReverse(new size());
			}
			else {
				return new size();
			}
		}
		else if (name.equals(Types.TYPE.toString())){
			if (suffix){
				return new DecoratorReverse(new type());
			}
			else {
				return new type();
			}
		}
		else {
			throw new WarningExceptions();
		}
	}
}
