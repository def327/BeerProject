
package by.beer.xml.parsers.builders;

import java.io.IOException;
import java.util.List;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.beer.entities.beeritem.BeerItem;
import by.beeritems.xml.parsers.sax.SAXBeerItemsParser;

/**
 * Class {@code BeerItemsSAXBuilder} can create a list of {@code BeerItem}
 * object's from XML file using
 * {@link BeerItemsSAXBuilder#buildListBeerItems(String)
 * buildListBeerItems()}method.
 * 
 * 
 * @author Dmitry Zyablov
 * 
 * @see BeerItem
 * 
 *
 */
public class BeerItemsSAXBuilder extends AbstractBeerItemsBuilder {

	/**
	 * Returns a list of initialized {@code BeerItem} object's from XML file.
	 * 
	 * @param fileName
	 *            - a path to XML file document
	 * 
	 * @return a list if {@code BeerItem} objects -
	 */
	@Override
	public List<BeerItem> buildListBeerItems(String fileName) {

		SAXBeerItemsParser hundler = new SAXBeerItemsParser();
		XMLReader reader;

		try {

			reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(hundler);
			reader.parse("xml//BeerItems.xml");
			super.beerItems = hundler.getBeerItemList();

		} catch (SAXException e) {
			System.err.println("Problem of parser");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.print("Problem of reading file" + fileName + "\n" + e);
			e.printStackTrace();
		}

		return (super.beerItems);
	}

}
