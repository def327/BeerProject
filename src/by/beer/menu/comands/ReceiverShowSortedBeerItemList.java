package by.beer.menu.comands;

import java.util.Scanner;
import by.beer.entities.beeritem.BeerItem;
import by.beer.entities.beeritem.comparators.ComparatorBeerItemByBeerClarity;
import by.beer.entities.beeritem.comparators.ComparatorBeerItemByFoodValue;

/**
 * Class {@code ReceiverShowSortedBeerItemList} realizes a user command to show
 * {@code BeerItem} objects in a sorted order.
 * 
 * 
 * @author Дмитрий Зяблов
 * 
 * @see BeerItem
 * 
 * @see ComparatorBeerItemByBeerClarity
 * @see ComparatorBeerItemByFoodValue
 *
 * 
 */
public class ReceiverShowSortedBeerItemList extends Receiver {

	@Override
	public void action() {
		System.out.println("Show iltems");
	}

	/**
	 * Constructs <code>ReceiverShowSortedBeerItemList</code> based om
	 * {@code Scanner} object.
	 * 
	 * @param consoleScaner
	 *            - a input stream for console.
	 * 
	 */
	public ReceiverShowSortedBeerItemList(Scanner consoleScaner) {
		super(consoleScaner);
	}

}
