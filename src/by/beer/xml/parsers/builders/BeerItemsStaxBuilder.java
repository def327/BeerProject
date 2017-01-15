package by.beer.xml.parsers.builders;

import java.util.List;

import by.beer.entities.beeritem.BeerItem;
import by.beeritems.xml.parsers.stax.StAXBeerItemsParser;

/**
 * @author Igor Shurupov
 *
 */
public class BeerItemsStaxBuilder extends AbstractBeerItemsBuilder {
	
	
	/**
	 * 
	 */
	public BeerItemsStaxBuilder() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<BeerItem> buildListBeerItems(String fileName) {
		StAXBeerItemsParser parser = new StAXBeerItemsParser();
		parser.buildListBeerItems("BeerItems.xml");
		return parser.getBeerItems();
	}

}
