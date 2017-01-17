package by.beer.menu.comands;

import by.beer.entities.beeritem.BeerItem;
import by.beeritems.xml.parsers.stax.StAXBeerItemsParser;
import by.beeritems.xml.parsers.sax.SAXBeerItemsParser;
import by.beeritems.xml.parsers.dom.DOMBeerItemsParser;

/**
 * CLass {@code ComandLoadBeerItemsFromXML} provides action to load
 * {@code BeerItem} objects from XML file document by StAX, SAX or DOM parsers.
 * 
 * @author Дмитрий Зяблов
 * 
 * @see IComand
 * @see BeerItem
 * @see StAXBeerItemsParser
 * @see SAXBeerItemsParser
 * @see DOMBeerItemsParser
 *
 */
public class ComandLoadBeerItemsFromXML implements IComand {

	/**
	 * Processes an action to load {@code BeerItem} objects from XML file
	 * document.
	 */
	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

}
