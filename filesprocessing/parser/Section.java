package filesprocessing.parser;

import filesprocessing.filter.Filter;
import filesprocessing.order.Order;

import java.util.LinkedList;

/**
 * This class creates section of filter and order objects with their warnings
 */
public class Section {

	/*
	class data members
	 */
	private Filter filter;
	private Order order;
	private LinkedList<String> warnings = new LinkedList<>();

	/**
	 * This constructor defaults the instance to null
	 */
	public Section(){
		filter = null;
		order = null;
	}

	/**
	 * set the filter object
	 * @param f Filter object to set
	 */
	public void setFilter(Filter f) {
		filter = f;
	}

	/**
	 * set the order object
	 * @param o Order object to set
	 */
	public void setOrder(Order o) {
		order = o;
	}

	/**
	 * adds warning to the warnings list
	 * @param warning a warning to add
	 */
	public void addWarning(String warning){
		warnings.add(warning);
	}

	/**
	 * @return the Fitler object
	 */
	public Filter getFilter(){
		return filter;
	}

	/**
	 * @return the Order object
	 */
	public Order getOrder(){
		return order;
	}

	/**
	 * @return the warnings list
	 */
	public LinkedList<String> getWarnings() {
		return warnings;
	}
}
