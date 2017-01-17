package by.beer.entities.beeritem.comparators;

import java.util.Comparator;

import by.beer.entities.beeritem.BeerItem;

/**
 * Compares {@code BeerItem} objects by their food value field.
 * 
 * 
 * @author Dmitry Zyablov
 *
 */
public class ComparatorBeerItemByFoodValue implements Comparator<Object> {

	/**
	 * Compares {@code BeerItem} objects by their beer food value fields.
	 * 
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

		float OneObjFoodValue = oneObj.getCharsData().getFoodValue();
		float TwoObjFoodValue = twoObj.getCharsData().getFoodValue();

		return (int) (OneObjFoodValue - TwoObjFoodValue);
	}

}
