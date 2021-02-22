package filesprocessing.order;

import java.io.File;
import java.util.LinkedList;

/**
 * This class is a decorator that reverse object with order ability.
 */
public class DecoratorReverse extends DecoratorOrder{

	public DecoratorReverse(Order order) {
		super(order);
	}

	@Override
	public LinkedList<File> sort(LinkedList<File> files) {
		return reverse(super.sort(files));
	}

	/*
	This method gets a files list and reverse it
	 */
	private LinkedList<File> reverse(LinkedList<File> files){
		LinkedList<File> reversedFiles = new LinkedList<>();
		File file2add = files.pollFirst();
		while (file2add != null){
			reversedFiles.addFirst(file2add);
			file2add = files.pollFirst();
		}
		return reversedFiles;
	}
}
