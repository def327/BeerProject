package by.beeritems.xml.parsers.dom;

import org.w3c.dom.DOMException;
import org.w3c.dom.Element;

import by.beer.entities.beeritem.BeerItem;
import by.beer.entities.beeritem.beerdata.chars.AlсoholBeverageСharacteristiсData;
import by.beer.entities.beeritem.beerdata.chars.SoftBeverageСharacteristiсData;
import by.beer.entities.beeritem.beerdata.chars.СharacteristiсData;

/**
 * Class {@code BeerCharsDataParser} provides method to parse
 * {@code СharacteristiсData} field for{@code BeerItem} object.
 * 
 * @author Дмитрий Зяблов
 * 
 * @see BeerItem
 * @see СharacteristiсData
 *
 */
public class BeerCharsDataParser {
	/**
	 * Return's a parsed {@code СharacteristiсData} object with initialized
	 * fields from XML document.
	 * 
	 * @param beerItemElement
	 *            - an element of parsed XML document
	 * 
	 * @return a {@code СharacteristiсData} object
	 * 
	 * @see СharacteristiсData
	 */
	protected static СharacteristiсData getParsedBeerChars(Element beerItemElement) {

		СharacteristiсData charsData = getParsedBeerTypeСharacteristiсData(beerItemElement);

		charsData.setBeerClarity(getParsedBeerClarity(beerItemElement));
		charsData.setFiltered(getParsedBeerIsFiltered(beerItemElement));
		charsData.setFoodValue(getParsedBeerIFoodValue(beerItemElement));
		charsData.setPackageType(BeerPackagingTypeParser.getParsedBeerPackagingType(beerItemElement));

		return charsData;
	}

	/**
	 * Return's a parsed beer food value for {@code BeerItem} object from XML
	 * document.
	 * 
	 * 
	 * @param beerItemElement
	 *            - an element of parsed XML document
	 * 
	 * 
	 * @return a food value
	 * 
	 * @throws NumberFormatException
	 * @throws DOMException
	 * 
	 * 
	 */
	private static float getParsedBeerIFoodValue(Element beerItemElement) throws NumberFormatException, DOMException {
		Element elemFoodValue = XMLDocumentChildElement.getChildElement(beerItemElement, "food-value");
		float beerFoodValue = Float.parseFloat(elemFoodValue.getTextContent());
		return beerFoodValue;
	}

	/**
	 * Return's a parsed beer boolean is filtered value for {@code BeerItem}
	 * object from XML document.
	 * 
	 * @param beerItemElement
	 *            - an element of parsed XML document
	 * 
	 * @return a boolean value if beer is filtered
	 * 
	 * @throws DOMException
	 */
	private static boolean getParsedBeerIsFiltered(Element beerItemElement) throws DOMException {
		Element elemIsFiltered = XMLDocumentChildElement.getChildElement(beerItemElement, "is-filtered");
		boolean beerIsFiltered = Boolean.parseBoolean(elemIsFiltered.getTextContent());

		return beerIsFiltered;
	}

	/**
	 * Return's a parsed beer clarity value for {@code BeerItem} object from XML
	 * document.
	 * 
	 * @param beerItemElement
	 *            - an element of parsed XML document
	 * 
	 * @return a beer clarity value
	 * 
	 * @throws DOMException
	 */
	private static int getParsedBeerClarity(Element beerItemElement) throws NumberFormatException, DOMException {
		Element elemBeerClarity = XMLDocumentChildElement.getChildElement(beerItemElement, "beer-clarity");
		int beerClarity = Integer.parseInt(elemBeerClarity.getTextContent());

		return beerClarity;
	}

	/**
	 * Return's a parsed {@code СharacteristiсData} object with initialized
	 * fields from XML document.
	 * 
	 * @param beerItemElement
	 *            - an element of parsed XML document
	 * 
	 * @return a {@code СharacteristiсData} object
	 * 
	 * @see СharacteristiсData
	 */
	private static СharacteristiсData getParsedBeerTypeСharacteristiсData(Element beerItemElement) {

		Element elemChars = XMLDocumentChildElement.getChildElement(beerItemElement, "chars");

		if (elemChars.hasAttribute("alcohol-volume")) {

			float beerAlcoholVolume = Float.parseFloat(elemChars.getAttribute("alcohol-volume"));
			AlсoholBeverageСharacteristiсData alсoholBeverageCharsData = new AlсoholBeverageСharacteristiсData();

			alсoholBeverageCharsData.setAlcoholVolume(beerAlcoholVolume);

			return alсoholBeverageCharsData;

		} else {

			SoftBeverageСharacteristiсData softBeverageCharsData = new SoftBeverageСharacteristiсData();
			return softBeverageCharsData;
		}

	}

	private BeerCharsDataParser() {
	}

}