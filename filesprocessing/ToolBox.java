package filesprocessing;

import java.io.File;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * This class is a static class which contains many calculating methods that relevant to project classes
 */
public final class ToolBox {

	/*
	constants
	 */
	private final static char HASH = '#';
	private final static char DOT = '.';
	private final static String EMPTY_STRING = "";
	private final static int NOT_FOUND = -1;

	private ToolBox(){

	}

	/**
	 * Go over files list and print the file names line by line
	 * @param files list of files
	 */
	public static void printFiles(LinkedList<File> files){
		for (File file :
				files) {
			System.out.println(file.getName());
		}
	}

	/**
	 * Go over warning list and print the rows line by line
	 * @param list list of warnings
	 */
	public static void printWarnings(LinkedList<String> list){
		for (String row :
				list) {
			System.err.println(row);
		}
	}

	/**
	 * @param fileName name to find its extension
	 * @return the extension of the input file name
	 */
	public static String getExtension(String fileName){
		int lastDot = fileName.lastIndexOf(DOT);
		if (lastDot == NOT_FOUND || lastDot == 0 || lastDot == fileName.length()-1){
			return EMPTY_STRING;
		}
		return fileName.substring(lastDot + 1);
	}

	/**
	 * @param input condition to search the name in
	 * @return The name of the input string (to the first hash).
	 */
	public static String getName(String input){
		int sup = input.indexOf(HASH);
		if (sup != NOT_FOUND){
			return input.substring(0, sup);
		}
		return input;
	}

	/**
	 * This method gets a string with hash values and split it to string array when hash is the separator.
	 * @param values string to split
	 * @return array of strings without the hash sign
	 */
	public static String[] string2array(String values){
		String[] arr;
		arr = new String[1];
		if (values.equals(EMPTY_STRING)){
			arr[0] = EMPTY_STRING;
		}
		else {
			int sup = values.indexOf(HASH);
			if (sup == NOT_FOUND){
				arr[0] = values;
			}
			else {
				arr = new String[2];
				arr[0] = values.substring(0, sup);
				arr[1] = values.substring(sup + 1);
			}
		}
		return arr;
	}

	/**
	 * find filter arguments (without name and suffix).
	 * @param input string to search in
	 * @param suffix true if there is a suffix
	 * @return the value without name and suffix
	 */
	public static String getFilterValue(String input, boolean suffix){
		int sup = input.indexOf(HASH);
		if (suffix){
			int lastSup = input.lastIndexOf(HASH);
			if (sup != lastSup){
				return input.substring(sup+1, input.lastIndexOf(HASH));
			}
			return EMPTY_STRING;
		}
		if (sup != NOT_FOUND){
			return input.substring(sup + 1);
		}
		return EMPTY_STRING;
	}

	/**
	 * @param input string to search in
	 * @param suffix value to search
	 * @return true if the second input is the suffix of the first input
	 */
	public static boolean hasSuffix(String input, String suffix){
		int sup = input.indexOf(suffix);
		return sup != NOT_FOUND;
	}

	/**
	 * This method implements merge sort algorithm by using merge method as helper. it gets comparator to
	 * compare according to him
	 * @param files the list needed to sort
	 * @param end the current length
	 * @param c comparator to define how to compare
	 */
	public static void mergeSort(LinkedList<File> files, int end, Comparator<File> c){
		if (end  < 2){
			return;
		}
		int mid = end / 2;
		LinkedList<File> left = new LinkedList<File>();
		LinkedList<File> right = new LinkedList<File>();
		for (int i = 0; i < mid; i++){
			left.add(files.get(i));
		}
		for (int j = mid; j < end; j++){
			right.add(files.get(j));
		}
		mergeSort(left, mid, c);
		mergeSort(right, end - mid, c);
		merge(files, left, right, mid, end - mid, c);
	}


	/**
	 * This method helps mergeSort to sort the files list. It using merge sort algorithm according to the
	 * input comparator
	 * @param files list to sort
	 * @param left left list to merge
	 * @param right right list to merge
	 * @param leftIndex left index
	 * @param rightIndex right index
	 * @param c comparator to define how to compare
	 */
	public static void merge(LinkedList<File> files, LinkedList<File> left, LinkedList<File> right,
							 int leftIndex, int rightIndex, Comparator<File> c){
		int l = 0;
		int r = 0;
		int i = 0;
		while (l < leftIndex && r < rightIndex){
			if (c.compare(left.get(l), right.get(r)) < 0){
				files.set(i++, left.get(l++));
			}
			else {
				files.set(i++, right.get(r++));
			}
		}
		while (l < leftIndex){
			files.set(i++, left.get(l++));
		}
		while (r < rightIndex){
			files.set(i++, right.get(r++));
		}
	}
}
