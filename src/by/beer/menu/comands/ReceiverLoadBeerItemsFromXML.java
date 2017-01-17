package by.beer.menu.comands;

import java.util.Scanner;

import by.beer.entities.beeritem.BeerItem;
import by.beeritems.xml.parsers.stax.StAXBeerItemsParser;
import by.beeritems.xml.parsers.sax.SAXBeerItemsParser;
import by.beeritems.xml.parsers.dom.DOMBeerItemsParser;

/**
 * Class {@code ReceiverLoadBeerItemsFromXML} realizes a user command to load
 * {@code BeerItem} objects from XML document file using StAX, SAX and DOM
 * parsers.
 * 
 * 
 * @author Дмитрий Зяблов
 * 
 * @see BeerItem
 * 
 * @see StAXBeerItemsParser
 * @see SAXBeerItemsParser
 * @see DOMBeerItemsParser
 *
 * 
 */
public class ReceiverLoadBeerItemsFromXML extends Receiver {

	@Override
	public void action() {
		System.out.println("Load from XML");

	}

	/**
	 * Constructs <code>ReceiverLoadBeerItemsFromXML</code> based om
	 * {@code Scanner} object.
	 * 
	 * @param consoleScaner
	 *            - a input stream for console.
	 * 
	 */
	public ReceiverLoadBeerItemsFromXML(Scanner consoleScaner) {
		super(consoleScaner);
	}

}
