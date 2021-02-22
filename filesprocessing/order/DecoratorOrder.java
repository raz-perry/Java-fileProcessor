package filesprocessing.order;

import java.io.File;
import java.util.LinkedList;

/**
 * This is an abstract class which represent decorators of objects with order abilities.
 */
public abstract class DecoratorOrder implements Order {

	private final Order order;

	public DecoratorOrder(Order order){
		this.order = order;
	}

	@Override
	public LinkedList<File> sort(LinkedList<File> files) {
		return order.sort(files);
	}
}
