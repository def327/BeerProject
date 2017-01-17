package by.beeritems.xml.parsers.dom;

import java.util.LinkedList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import by.beer.entities.beeritem.BeerItem;
import by.beer.entities.beeritem.beerdata.ChemicalComponentsComposition;
import by.beer.entities.beeritem.beerdata.TradeBrandBeerdata;
import by.beer.entities.beeritem.beerdata.chars.СharacteristiсData;

/**
 * Class {@code DOMBeerItemsParser} provides method to parse and transfer an XML
 * document with information for {@code BeerItem} objects. Also provides methods
 * to initialize the fields for {@code BeerItem} objects.
 * 
 * @author Dmitry Zyablov
 * 
 * @see BeerItem
 *
 */
public class DOMBeerItemsParser {

	/**
	 * Returns {@code BeerItem} objects from parsed XML document
	 * 
	 * @param root
	 *            - is XML document
	 * 
	 * @return a list of {@code BeerItem} objects
	 */
	public static List<BeerItem> listBuilder(Element root) {

		// -- An container for BeerItem objects
		List<BeerItem> beerItemList = new LinkedList<>();

		// -- Get a list of 'beer' elements
		NodeList beerElement = root.getElementsByTagName("beer");

		for (int beerElementIter = 0; beerElementIter < beerElement.getLength(); beerElementIter++) {

			Element beerItemElement = (Element) beerElement.item(beerElementIter);
			BeerItem beerItem = buildBeerItem(beerItemElement);

			// Add a new BeerItem object to list of BeerItem objects
			beerItemList.add(beerItem);

		}

		return beerItemList;
	}

	/**
	 * Returns an initialized {@code BeerItem} object by data from parsed XML
	 * document.
	 * 
	 * @param beerItemElement
	 *            - an element from parsed XML document which hava all nessesary
	 *            data to initialize a new {@code BeerItem} object.
	 * 
	 * @return a new {@code BeerItem} object
	 * 
	 * @see BeerItem.BuilderBeerItem
	 */
	private static BeerItem buildBeerItem(Element beerItemElement) {

		/*
		 * Get all necessary data to initialize all fields of a new BeerItem
		 * object
		 * 
		 */
		int beerId = BeerIDParser.getParsedBeerID(beerItemElement);
		TradeBrandBeerdata beerBrandData = BeerBrandDataParser.getParsedBeerBrandData(beerItemElement);
		ChemicalComponentsComposition beerChemicalComposition = BeerChemicalCompositionParser
				.getParsedBeerChemicalComposition(beerItemElement);
		String beerAlcoholType = BeerAlcoholTypeParser.getParsedBeerAlcoholType(beerItemElement);
		СharacteristiсData beerCharsData = BeerCharsDataParser.getParsedBeerChars(beerItemElement);

		// Initializing fields of a new BeerItem by inner Class
		BeerItem newBeerItem = new BeerItem.BuilderBeerItem().beerId(beerId).brandData(beerBrandData)
				.chemicalComposition(beerChemicalComposition).alcoholBeerType(beerAlcoholType).charsData(beerCharsData)
				.newInstance();

		return newBeerItem;
	}

	private DOMBeerItemsParser() {
	}

}
