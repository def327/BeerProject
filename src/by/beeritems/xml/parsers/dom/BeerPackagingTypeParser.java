package by.beeritems.xml.parsers.dom;

import org.w3c.dom.Element;

import by.beer.entities.beeritem.BeerItem;
import by.beer.entities.beeritem.beerdata.chars.PackageType;

/**
 * Class {@code BeerPackagingTypeParser} provides method to parse
 * {@code PackageType} field for {@code СharacteristiсData} field of
 * {@code BeerItem} object.
 * 
 * @author Dmitry Zyablov
 * 
 * @see BeerItem
 * @see СharacteristiсData
 * @see PackageType
 *
 */
public class BeerPackagingTypeParser {

	/**
	 * Return's a parsed {@code PackageType} object with initialized fields from
	 * XML document.
	 * 
	 * @param beerItemElement
	 *            - an element of parsed XML document
	 * 
	 * @return a {@code PackageType} object
	 * 
	 * @see PackageType
	 */
	protected static PackageType getParsedBeerPackagingType(Element beerItemElement) {

		PackageType packageType = new PackageType();
		packageType.setPackageCapacity(getParsedBeerPackageCapacity(beerItemElement));
		packageType.setPackageMaterial(getParsedBeerPackageMaterial(beerItemElement));

		return packageType;
	}

	/**
	 * Return's a parsed material type for {@code BeerItem} object from XML
	 * document.
	 * 
	 * 
	 * @param beerItemElement
	 *            - an element of parsed XML document
	 * 
	 * @return a package material type in String
	 */
	private static String getParsedBeerPackageMaterial(Element beerItemElement) {
		Element elemPackageMaterial = XMLDocumentChildElement.getChildElement(beerItemElement, "package-material");
		String beerPackageMaterial = elemPackageMaterial.getTextContent();
		return beerPackageMaterial;
	}

	/**
	 * Return's a parsed package capacity for {@code BeerItem} object from XML
	 * document.
	 * 
	 * 
	 * @param beerItemElement
	 *            - an element of parsed XML document
	 * 
	 * @return a package capacity
	 */
	private static float getParsedBeerPackageCapacity(Element beerItemElement) {
		Element elemPackageCapacity = XMLDocumentChildElement.getChildElement(beerItemElement, "package-capacity");
		float beerPackageCapacity = Float.parseFloat(elemPackageCapacity.getTextContent());
		return beerPackageCapacity;
	}

	private BeerPackagingTypeParser() {

	}

}