package by.beeritems.xml.parsers.dom;

import org.w3c.dom.DOMException;
import org.w3c.dom.Element;

import by.beer.entities.beeritem.BeerItem;
import by.beer.entities.beeritem.beerdata.TradeBrandBeerdata;

/**
 * Class {@code BeerBrandDataParser} provides method to parse
 * {@code TradeBrandBeerdata} field for{@code BeerItem} object.
 * 
 * @author Дмитрий Зяблов
 * 
 * @see BeerItem
 * @see TradeBrandBeerdata
 *
 */
public class BeerBrandDataParser {

	/**
	 * Return's a parsed {@code TradeBrandBeerdata} object with initialized
	 * fields from XML document.
	 * 
	 * @param beerItemElement
	 *            - an element of parsed XML document
	 * 
	 * @return a {@code TradeBrandBeerdata} object
	 * 
	 * @see TradeBrandBeerdata
	 */
	protected static TradeBrandBeerdata getParsedBeerBrandData(Element beerItemElement) {

		TradeBrandBeerdata tradeBrandBeerData = new TradeBrandBeerdata();

		tradeBrandBeerData.setBeerName(getParsedBeerName(beerItemElement));
		tradeBrandBeerData.setSortBeerType(getParsedBeerSortType(beerItemElement));
		tradeBrandBeerData.setManufacturerBeerName(getParsedBeerManufacturer(beerItemElement));

		return tradeBrandBeerData;
	}

	/**
	 * 
	 * Return's a parsed a name of manufacturer beer company for
	 * {@code BeerItem} object from XML document.
	 * 
	 * 
	 * @param beerItemElement
	 *            - an element of parsed XML document
	 * 
	 * @return a name of manufacturer
	 * 
	 * 
	 * @throws DOMException
	 */
	private static String getParsedBeerManufacturer(Element beerItemElement) throws DOMException {
		Element elemManufacturer = XMLDocumentChildElement.getChildElement(beerItemElement, "manufacturer");
		String beerManufacturer = elemManufacturer.getTextContent();

		return beerManufacturer;
	}

	/**
	 * 
	 * Return's a parsed a name beer sort for {@code BeerItem} object from XML
	 * document.
	 * 
	 * 
	 * @param beerItemElement
	 *            - an element of parsed XML document
	 * 
	 * @return a name of beer sort
	 * 
	 * 
	 * @throws DOMException
	 */
	private static String getParsedBeerSortType(Element beerItemElement) throws DOMException {
		Element elemSortType = XMLDocumentChildElement.getChildElement(beerItemElement, "sort-type");
		String beerSortType = elemSortType.getTextContent();

		return beerSortType;
	}

	/**
	 * 
	 * Return's a parsed a name of beer for {@code BeerItem} object from XML
	 * document.
	 * 
	 * 
	 * @param beerItemElement
	 *            - an element of parsed XML document
	 * 
	 * @return a name of beer
	 * 
	 * 
	 * @throws DOMException
	 */
	private static String getParsedBeerName(Element beerItemElement) throws DOMException {
		Element elemName = XMLDocumentChildElement.getChildElement(beerItemElement, "name");
		String beerName = elemName.getTextContent();

		return beerName;
	}

	private BeerBrandDataParser() {

	}

}