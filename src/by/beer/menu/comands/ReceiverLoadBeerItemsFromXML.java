package by.beer.menu.comands;

import static by.beer.enums.PathToXMLDocument.*;

import java.util.List;
import java.util.Scanner;

import by.beer.entities.beeritem.BeerItem;
import by.beer.entities.beeritem.manager.ManagerBeerItem;
import by.beer.resources.ResourceBundleManager;
import by.beer.xml.parsers.builders.AbstractBeerItemsBuilder;
import by.beer.xml.parsers.builders.BeerItemsDOMBuilder;
import by.beer.xml.parsers.builders.BeerItemsSAXBuilder;
import by.beer.xml.parsers.builders.BeerItemsStaxBuilder;
import by.beeritems.xml.parsers.dom.DOMBeerItemsParser;
import by.beeritems.xml.parsers.sax.SAXBeerItemsParser;
import by.beeritems.xml.parsers.stax.StAXBeerItemsParser;

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

	/**
	 * Load {@code BeerItem} objects from XML file document.
	 */
	@Override
	public void action() {

		AbstractBeerItemsBuilder builderBeerItem;
		while (true) {
			try {
				System.out.println(ResourceBundleManager.getProperty("mainMenu.load"));

				String comandAction = this.consoleScaner.nextLine();

				switch (comandAction) {
				case "1": {
					System.out.println(ResourceBundleManager.getProperty("mainMenu.load.stax"));
					builderBeerItem = new BeerItemsStaxBuilder();
					this.manager.setListBeerItem(
							(List<BeerItem>) builderBeerItem.buildListBeerItems(PATH_TO_XML_DOCUMENT.toString()));
					return;
				}

				case "2": {
					System.out.println(ResourceBundleManager.getProperty("mainMenu.load.sax"));
					builderBeerItem = new BeerItemsSAXBuilder();
					this.manager.setListBeerItem(
							(List<BeerItem>) builderBeerItem.buildListBeerItems(PATH_TO_XML_DOCUMENT.toString()));
					return;
				}

				case "3": {
					System.out.println(ResourceBundleManager.getProperty("mainMenu.load.dom"));
					builderBeerItem = new BeerItemsDOMBuilder();
					this.manager.setListBeerItem(
							(List<BeerItem>) builderBeerItem.buildListBeerItems(PATH_TO_XML_DOCUMENT.toString()));
					return;
				}

				default: {
					System.out.println(ResourceBundleManager.getProperty("menu.try"));
					// Ask user again
					continue;
				}
				}
			} catch (IllegalArgumentException e) {
				System.out.println(ResourceBundleManager.getProperty("menu.try"));
				// Ask user again
				continue;
			}

		}

	}

	/**
	 * Constructs <code>ReceiverLoadBeerItemsFromXML</code> based om
	 * {@code Scanner} object.
	 * 
	 * @param consoleScaner
	 *            - a input stream for console.
	 * @param manager
	 *            - a storage for a list of {@code BeerItem} objects.
	 */
	public ReceiverLoadBeerItemsFromXML(Scanner consoleScaner, ManagerBeerItem manager) {
		super(consoleScaner, manager);
	}

}
