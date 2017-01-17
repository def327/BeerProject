package by.beer.entities.beeritem.comparators;

import java.util.Comparator;

import by.beer.entities.beeritem.BeerItem;

/**
 * Compares {@code BeerItem} objects by their beer clarity field.
 * 
 * @author Дмитрий
 * @version 1.0
 * @since 2016
 * 
 * @author Dmitry Zyablov
 *
 */
public class ComparatorBeerItemByBeerClarity implements Comparator<Object> {

	/**
	 * Compares {@code BeerItem} objects by their beer clarity fields.
	 * 
	 * @param o1
	 *            - the comparable reference object
	 * @param o2
	 *            - the reference object with which to compare
	 * 
	 * @return the value {@code 0} if the argument obj is equal to this
	 *         {@code BeerItem} object; a value less than {@code 0} if this
	 *         {@code BeerItem} object is less than the obj argument; and a
	 *         value greater than {@code 0} if this {@code BeerItem} object is
	 *         greater than the obj argument.
	 */
	@Override
	public int compare(Object o1, Object o2) {
		BeerItem oneObj = (BeerItem) o1;
		BeerItem twoObj = (BeerItem) o2;

		int oneObjBeerClarity = (int) oneObj.getCharsData().getBeerClarity();
		int twoObjBeerClarity = (int) twoObj.getCharsData().getBeerClarity();

		return (oneObjBeerClarity - twoObjBeerClarity);
	}

}
