package by.beeritems.xml.parsers.dom;

import org.w3c.dom.DOMException;
import org.w3c.dom.Element;

import by.beer.entities.beeritem.BeerItem;

/**
 * Class {@code BeerAlcoholTypeParser} provides method to parse alcohol type
 * field for{@code BeerItem} object.
 * 
 * @author Дмитрий Зяблов
 * 
 * @see BeerItem
 *
 */
public class BeerAlcoholTypeParser {

	/**
	 * Return's a parsed beer alcohol type for {@code BeerItem} object from XML
	 * document.
	 * 
	 * @param beerItemElement
	 *            - an element of parsed XML document
	 * 
	 * @return a beer alcohol type
	 * 
	 * @throws DOMException
	 */
	protected static String getParsedBeerAlcoholType(Element beerItemElement) {
		Element elemAlcohol = XMLDocumentChildElement.getChildElement(beerItemElement, "alcohol");
		String beerAlcohol = elemAlcohol.getTextContent();
		return beerAlcohol;
	}

	private BeerAlcoholTypeParser() {
	}

}