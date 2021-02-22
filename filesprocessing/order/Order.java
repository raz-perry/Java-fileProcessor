package filesprocessing.order;

import java.io.File;
import java.util.LinkedList;

/**
 * This is an interface of objects that knows how to sort files list
 */
public interface Order {

	LinkedList<File> sort(LinkedList<File> files);

}
