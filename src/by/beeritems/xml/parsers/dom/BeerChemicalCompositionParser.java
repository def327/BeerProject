package by.beeritems.xml.parsers.dom;

import org.w3c.dom.DOMException;
import org.w3c.dom.Element;

import by.beer.entities.beeritem.BeerItem;
import by.beer.entities.beeritem.beerdata.ChemicalComponentsComposition;

/**
 * Class {@code BeerChemicalCompositionParser} provides method to parse
 * {@code ChemicalComponentsComposition} field for{@code BeerItem} object.
 * 
 * @author Дмитрий Зяблов
 * 
 * @see BeerItem
 * @see ChemicalComponentsComposition
 *
 */
public class BeerChemicalCompositionParser {

	/**
	 * Return's a parsed {@code ChemicalComponentsComposition} object with
	 * initialized fields from XML document.
	 * 
	 * @param beerItemElement
	 *            - an element of parsed XML document
	 * 
	 * @return a {@code ChemicalComponentsComposition} object
	 * 
	 * @see ChemicalComponentsComposition
	 */
	protected static ChemicalComponentsComposition getParsedBeerChemicalComposition(Element beerItemElement) {

		ChemicalComponentsComposition chemicalComponentsBeerComposition = new ChemicalComponentsComposition();

		chemicalComponentsBeerComposition.setWaterСapacity(getParsedBeerIngredientWater(beerItemElement));
		chemicalComponentsBeerComposition.setSugarСapacity(getParsedBeerIngredientSugar(beerItemElement));
		chemicalComponentsBeerComposition.setHopСapacity(getParsedBeerIngredientHop(beerItemElement));
		chemicalComponentsBeerComposition.setMaltСapacity(getParsedBeerIngredientMalt(beerItemElement));
		chemicalComponentsBeerComposition.setYeastСapacity(getParsedBeerIngredientYeast(beerItemElement));

		return chemicalComponentsBeerComposition;
	}

	/**
	 * Return's a parsed a capacity of yeast in beer for {@code BeerItem} object
	 * from XML document.
	 * 
	 * @param beerItemElement
	 *            - an element of parsed XML document
	 * 
	 * @return a capacity of yeast in beer
	 * 
	 * @throws NumberFormatException
	 * @throws DOMException
	 */
	private static int getParsedBeerIngredientYeast(Element beerItemElement)
			throws NumberFormatException, DOMException {
		Element yeast = XMLDocumentChildElement.getChildElement(beerItemElement, "yeast");
		int beerIngredientYeast = Integer.parseInt(yeast.getTextContent());

		return beerIngredientYeast;
	}

	/**
	 * Return's a parsed a capacity of malt in beer for {@code BeerItem} object
	 * from XML document.
	 * 
	 * @param beerItemElement
	 *            - an element of parsed XML document
	 * 
	 * @return a capacity of malt in beer
	 * 
	 * 
	 * @throws NumberFormatException
	 * @throws DOMException
	 */
	private static int getParsedBeerIngredientMalt(Element beerItemElement) throws NumberFormatException, DOMException {
		Element malt = XMLDocumentChildElement.getChildElement(beerItemElement, "malt");
		int beerIngredientMalt = Integer.parseInt(malt.getTextContent());

		return beerIngredientMalt;
	}

	/**
	 * Return's a parsed a capacity of hop in beer for {@code BeerItem} object
	 * from XML document.
	 * 
	 * @param beerItemElement
	 *            - an element of parsed XML document
	 * 
	 * @return a capacity of hop in beer
	 * 
	 * @throws NumberFormatException
	 * @throws DOMException
	 */
	private static int getParsedBeerIngredientHop(Element beerItemElement) throws NumberFormatException, DOMException {
		Element hop = XMLDocumentChildElement.getChildElement(beerItemElement, "hop");
		int beerIngredientHop = Integer.parseInt(hop.getTextContent());

		return beerIngredientHop;
	}

	/**
	 * Return's a parsed a capacity of sugar in beer for {@code BeerItem} object
	 * from XML document.
	 * 
	 * @param beerItemElement
	 *            - an element of parsed XML document
	 * 
	 * @return a capacity of sugar in beer
	 * 
	 * @throws NumberFormatException
	 * @throws DOMException
	 */
	private static int getParsedBeerIngredientSugar(Element beerItemElement)
			throws NumberFormatException, DOMException {
		Element sugar = XMLDocumentChildElement.getChildElement(beerItemElement, "sugar");
		int beerIngredientSugar = Integer.parseInt(sugar.getTextContent());

		return beerIngredientSugar;
	}

	/**
	 * Return's a parsed a capacity of water in beer for {@code BeerItem} object
	 * from XML document.
	 * 
	 * @param beerItemElement
	 *            - an element of parsed XML document
	 * 
	 * @return a capacity of water in beer
	 * 
	 * @throws NumberFormatException
	 * @throws DOMException
	 */
	private static int getParsedBeerIngredientWater(Element beerItemElement)
			throws NumberFormatException, DOMException {
		Element water = XMLDocumentChildElement.getChildElement(beerItemElement, "water");
		int beerIngredientWater = Integer.parseInt(water.getTextContent());

		return beerIngredientWater;
	}

	private BeerChemicalCompositionParser() {
	}

}