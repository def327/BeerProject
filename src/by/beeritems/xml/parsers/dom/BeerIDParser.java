package by.beeritems.xml.parsers.dom;

import org.w3c.dom.DOMException;
import org.w3c.dom.Element;

import by.beer.entities.beeritem.BeerItem;

/**
 * Class {@code BeerIDParser} provides method to parse beer ID field
 * for{@code BeerItem} object.
 * 
 * @author Дмитрий Зяблов
 * 
 * @see BeerItem
 *
 */
public class BeerIDParser {

	/**
	 * 
	 * Return's a parsed ID of beer for {@code BeerItem} object from XML
	 * document.
	 * 
	 * 
	 * @param beerItemElement
	 *            - an element of parsed XML document
	 * 
	 * @return a unique ID for {@code BeerItem} object
	 * 
	 * 
	 * @throws DOMException
	 */
	protected static int getParsedBeerID(Element beerItemElement) throws NumberFormatException {
		int beerId = Integer.parseInt(beerItemElement.getAttribute("beer-id"));
		return beerId;
	}

	private BeerIDParser() {

	}
}