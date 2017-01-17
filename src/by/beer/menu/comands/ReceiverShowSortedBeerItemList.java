package by.beer.menu.comands;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import by.beer.entities.beeritem.BeerItem;
import by.beer.entities.beeritem.comparators.ComparatorBeerItemByBeerClarity;
import by.beer.entities.beeritem.comparators.ComparatorBeerItemByFoodValue;
import by.beer.entities.beeritem.manager.ManagerBeerItem;

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

	/**
	 * Show a sorted list of {@code BeerItem} objects.
	 */
	@Override
	public void action() {

		if (!manager.haveBeerItemObjects()) {
			System.out.println("Storage is empty! Please load BeerItem objects from XML file document using parser.");
			return;
		}

		while (true) {
			try {

				System.out.println("Choose a type of sorting: ");
				System.out.println("1 - by beer clarity");
				System.out.println("2 - by food value");

				String comandAction = this.consoleScaner.nextLine();

				switch (comandAction) {
				case "1": {
					System.out.println("Sorted by beer clarity:");

					showSortedBeerItemList(this.manager.getListBeerItem(), new ComparatorBeerItemByBeerClarity());

					return;
				}

				case "2": {
					System.out.println("Sorted by food value");

					showSortedBeerItemList(this.manager.getListBeerItem(), new ComparatorBeerItemByFoodValue());

					return;
				}

				default: {
					System.out.println("Try again");
					// Ask user again
					continue;
				}
				}
			} catch (IllegalArgumentException e) {
				System.out.println("Try again");
				// Ask user again
				continue;
			}

		}

	}

	/**
	 * Displays a sorted list of {@code BeerItem} objects.
	 * 
	 * @param listBeerItem
	 *            - a list of {@code BeerItem} objects.
	 * 
	 * @param comparator
	 *            - a comparator to compare {@code BeerItem} objects.
	 */
	private void showSortedBeerItemList(List<BeerItem> listBeerItem, Comparator<Object> comparator) {

		List<BeerItem> listToSort = new ArrayList<>(listBeerItem);
		listToSort.sort(comparator);

		for (Iterator<BeerItem> iterator = listToSort.iterator(); iterator.hasNext();) {
			BeerItem beerItem = (BeerItem) iterator.next();

			System.out.println("ID--" + beerItem.getBeerId() + "--Name--" + beerItem.getBrandData().getBeerName()
					+ "--Manufacturer--" + beerItem.getBrandData().getManufacturerBeerName());
		}

	}

	/**
	 * Constructs <code>ReceiverShowSortedBeerItemList</code> based om
	 * {@code Scanner} object.
	 * 
	 * @param consoleScaner
	 *            - a input stream for console.
	 * @param manager
	 *            - a storage for a list of {@code BeerItem} objects.
	 * 
	 */
	public ReceiverShowSortedBeerItemList(Scanner consoleScaner, ManagerBeerItem manager) {
		super(consoleScaner, manager);
	}

}
