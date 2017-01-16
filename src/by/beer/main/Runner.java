/**
 * 
 */
package by.beer.main;

import java.util.Iterator;
import java.util.List;

import by.beer.entities.beeritem.BeerItem;
import by.beer.xml.parsers.builders.AbstractBeerItemsBuilder;
import by.beer.xml.parsers.builders.BeerItemsDOMBuilder;

/**
 * @author Дмитрий
 *
 */
public class Runner {

	/**
	 * Test parsers here
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		String pathToXMLDocument = "xml\\BeerItems.xml";

		AbstractBeerItemsBuilder beerItemsBuilder = new BeerItemsDOMBuilder();

		List<BeerItem> list = beerItemsBuilder.buildListBeerItems(pathToXMLDocument);

		for (Iterator<BeerItem> iterator = list.iterator(); iterator.hasNext();) {
			BeerItem beerItem = (BeerItem) iterator.next();

			System.out.println(beerItem.getCharsData().toString());
		}

	}

}
