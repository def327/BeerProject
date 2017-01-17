package by.beer.menu;

import java.util.Iterator;
import java.util.List;

import by.beer.entities.beeritem.BeerItem;
import by.beer.xml.parsers.builders.AbstractBeerItemsBuilder;
import by.beer.xml.parsers.builders.BeerItemsDOMBuilder;

/**
 * Class {@code SingleApplicationMenuFactory} represents a menu for user via
 * console.
 * 
 * @author Дмитрий Зяблов
 *
 */
public class SingleApplicationMenuFactory {

	/**
	 * A uniqiue sinagle instanse of {@code SingleApplicationMenuFactory} class.
	 */
	public volatile static SingleApplicationMenuFactory applicationMenuObject;

	/**
	 * Return's a {@code SingleApplicationMenuFactory} reference object.
	 * 
	 * @return a SingleApplicationMenuFactory object
	 */
	public static SingleApplicationMenuFactory getInstance() {

		if (applicationMenuObject == null) {

			synchronized (SingleApplicationMenuFactory.class) {
				if (applicationMenuObject == null) {
					applicationMenuObject = new SingleApplicationMenuFactory();
				}
			}

		}
		return applicationMenuObject;
	}

	/**
	 * Do work by {@code SingleApplicationMenuFactory} object.
	 */
	public void run() {
		// TODO Change

		String pathToXMLDocument = "xml//BeerItems.xml";

		AbstractBeerItemsBuilder beerItemsBuilder = new BeerItemsDOMBuilder();

		List<BeerItem> list = beerItemsBuilder.buildListBeerItems(pathToXMLDocument);

		for (Iterator<BeerItem> iterator = list.iterator(); iterator.hasNext();) {
			BeerItem beerItem = (BeerItem) iterator.next();

			System.out.println(beerItem.getCharsData().toString());
		}

	}

	/**
	 * Default constructor for {@code SingleApplicationMenuFactory}
	 */
	private SingleApplicationMenuFactory() {

	}

}
