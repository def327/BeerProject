package by.beer.xml.parsers.builders;

import java.util.List;

import by.beer.entities.beeritem.BeerItem;
import by.beeritems.xml.parsers.stax.StAXBeerItemsParser;

/**
 * Class {@code BeerItemsStaxBuider} provides method to create {@code StaxBeerItemsParser} object and get a list of initialized {@code BeerItem} objects
 * 
 * @author Igor Shurupov
 */
public class BeerItemsStaxBuilder extends AbstractBeerItemsBuilder {
	
	
	/**
	 * 
	 */
	public BeerItemsStaxBuilder() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Returns a list of initialized {@code BeerItem} object's from XML file
	 * 
	 * @param fileName - is XML document
	 * 
	 * @return a list if {@code BeerItem} objects 
	 */
	@Override
	public List<BeerItem> buildListBeerItems(String fileName) {
		StAXBeerItemsParser staxParser = new StAXBeerItemsParser();
		staxParser.buildListBeerItems(fileName);
		return staxParser.getBeerItems();
	}

}
