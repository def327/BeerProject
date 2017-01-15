package by.beeritems.xml.parsers.dom;

import java.util.LinkedList;
import java.util.List;

import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import by.beer.entities.beeritem.BeerItem;
import by.beer.entities.beeritem.beerdata.ChemicalComponentsComposition;
import by.beer.entities.beeritem.beerdata.TradeBrandBeerdata;
import by.beer.entities.beeritem.beerdata.chars.AlсoholBeverageСharacteristiсData;
import by.beer.entities.beeritem.beerdata.chars.PackageType;
import by.beer.entities.beeritem.beerdata.chars.SoftBeverageСharacteristiсData;
import by.beer.entities.beeritem.beerdata.chars.СharacteristiсData;

/**
 * Class {@code DOMBeerItemsParser} provides method to parse and transfer an XML
 * document with information for {@code BeerItem} objects. Also provides methods
 * to initialize the fields for {@code BeerItem} objects.
 * 
 * @author Дмитрий Зяблов
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
	 */
	private static BeerItem buildBeerItem(Element beerItemElement) {

		BeerItem beerItem = new BeerItem();

		beerItem.setBeerId(getParsedBeerID(beerItemElement));
		beerItem.setBrandData(getParsedBeerBrandData(beerItemElement));
		beerItem.setChemicalComposition(getParsedBeerChemicalComposition(beerItemElement));
		beerItem.setAlcoholBeerType(getParsedBeerAlcoholType(beerItemElement));
		beerItem.setCharsData(getParsedBeerChars(beerItemElement));

		return beerItem;
	}

	private static СharacteristiсData getParsedBeerChars(Element beerItemElement) {

		СharacteristiсData charsData = getParsedBeerTypeСharacteristiсData(beerItemElement);

		charsData.setBeerClarity(getParsedBeerClarity(beerItemElement));
		charsData.setFiltered(getParsedBeerIsFiltered(beerItemElement));
		charsData.setFoodValue(getParsedBeerIFoodValue(beerItemElement));
		charsData.setPackageType(getParsedBeerPackagingType(beerItemElement));

		return charsData;
	}

	private static PackageType getParsedBeerPackagingType(Element beerItemElement) {

		PackageType packageType = new PackageType();
		packageType.setPackageCapacity(getParsedBeerPackageCapacity(beerItemElement));
		packageType.setPackageMaterial(getParsedBeerPackageMaterial(beerItemElement));

		return packageType;
	}

	private static String getParsedBeerPackageMaterial(Element beerItemElement) {
		Element elemPackageMaterial = DOMBeerItemsParser.getChildElement(beerItemElement, "package-material");
		String beerPackageMaterial = elemPackageMaterial.getTextContent();
		return beerPackageMaterial;
	}

	private static float getParsedBeerPackageCapacity(Element beerItemElement) {
		Element elemPackageCapacity = DOMBeerItemsParser.getChildElement(beerItemElement, "package-capacity");
		float beerPackageCapacity = Float.parseFloat(elemPackageCapacity.getTextContent());
		return beerPackageCapacity;
	}

	/**
	 * @param beerItemElement
	 * @throws NumberFormatException
	 * @throws DOMException
	 */
	private static float getParsedBeerIFoodValue(Element beerItemElement) throws NumberFormatException, DOMException {
		Element elemFoodValue = DOMBeerItemsParser.getChildElement(beerItemElement, "food-value");
		float beerFoodValue = Float.parseFloat(elemFoodValue.getTextContent());
		return beerFoodValue;
	}

	/**
	 * @param beerItemElement
	 * @throws DOMException
	 */
	private static boolean getParsedBeerIsFiltered(Element beerItemElement) throws DOMException {
		Element elemIsFiltered = DOMBeerItemsParser.getChildElement(beerItemElement, "is-filtered");
		boolean beerIsFiltered = Boolean.parseBoolean(elemIsFiltered.getTextContent());

		return beerIsFiltered;
	}

	/**
	 * @param beerItemElement
	 * @throws NumberFormatException
	 * @throws DOMException
	 */
	private static int getParsedBeerClarity(Element beerItemElement) throws NumberFormatException, DOMException {
		Element elemBeerClarity = DOMBeerItemsParser.getChildElement(beerItemElement, "beer-clarity");
		int beerClarity = Integer.parseInt(elemBeerClarity.getTextContent());

		return beerClarity;
	}

	private static СharacteristiсData getParsedBeerTypeСharacteristiсData(Element beerItemElement) {

		Element elemChars = DOMBeerItemsParser.getChildElement(beerItemElement, "chars");

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

	private static String getParsedBeerAlcoholType(Element beerItemElement) {
		Element elemAlcohol = DOMBeerItemsParser.getChildElement(beerItemElement, "alcohol");
		String beerAlcohol = elemAlcohol.getTextContent();
		return beerAlcohol;
	}

	private static ChemicalComponentsComposition getParsedBeerChemicalComposition(Element beerItemElement) {

		ChemicalComponentsComposition chemicalComponentsBeerComposition = new ChemicalComponentsComposition();

		chemicalComponentsBeerComposition.setWaterСapacity(getParsedBeerIngredientWater(beerItemElement));
		chemicalComponentsBeerComposition.setSugarСapacity(getParsedBeerIngredientSugar(beerItemElement));
		chemicalComponentsBeerComposition.setHopСapacity(getParsedBeerIngredientHop(beerItemElement));
		chemicalComponentsBeerComposition.setMaltСapacity(getParsedBeerIngredientMalt(beerItemElement));
		chemicalComponentsBeerComposition.setYeastСapacity(getParsedBeerIngredientYeast(beerItemElement));

		return chemicalComponentsBeerComposition;
	}

	/**
	 * @param beerItemElement
	 * @throws NumberFormatException
	 * @throws DOMException
	 */
	private static int getParsedBeerIngredientYeast(Element beerItemElement)
			throws NumberFormatException, DOMException {
		Element yeast = DOMBeerItemsParser.getChildElement(beerItemElement, "yeast");
		int beerIngredientYeast = Integer.parseInt(yeast.getTextContent());

		return beerIngredientYeast;
	}

	/**
	 * @param beerItemElement
	 * @throws NumberFormatException
	 * @throws DOMException
	 */
	private static int getParsedBeerIngredientMalt(Element beerItemElement) throws NumberFormatException, DOMException {
		Element malt = DOMBeerItemsParser.getChildElement(beerItemElement, "malt");
		int beerIngredientMalt = Integer.parseInt(malt.getTextContent());

		return beerIngredientMalt;
	}

	/**
	 * @param beerItemElement
	 * @throws NumberFormatException
	 * @throws DOMException
	 */
	private static int getParsedBeerIngredientHop(Element beerItemElement) throws NumberFormatException, DOMException {
		Element hop = DOMBeerItemsParser.getChildElement(beerItemElement, "hop");
		int beerIngredientHop = Integer.parseInt(hop.getTextContent());

		return beerIngredientHop;
	}

	/**
	 * @param beerItemElement
	 * @throws NumberFormatException
	 * @throws DOMException
	 */
	private static int getParsedBeerIngredientSugar(Element beerItemElement)
			throws NumberFormatException, DOMException {
		Element sugar = DOMBeerItemsParser.getChildElement(beerItemElement, "sugar");
		int beerIngredientSugar = Integer.parseInt(sugar.getTextContent());

		return beerIngredientSugar;
	}

	/**
	 * @param beerItemElement
	 * @throws NumberFormatException
	 * @throws DOMException
	 */
	private static int getParsedBeerIngredientWater(Element beerItemElement)
			throws NumberFormatException, DOMException {
		Element water = DOMBeerItemsParser.getChildElement(beerItemElement, "water");
		int beerIngredientWater = Integer.parseInt(water.getTextContent());

		return beerIngredientWater;
	}

	private static TradeBrandBeerdata getParsedBeerBrandData(Element beerItemElement) {

		TradeBrandBeerdata tradeBrandBeerData = new TradeBrandBeerdata();

		tradeBrandBeerData.setBeerName(getParsedBeerName(beerItemElement));
		tradeBrandBeerData.setSortBeerType(getParsedBeerSortType(beerItemElement));
		tradeBrandBeerData.setManufacturerBeerName(getParsedBeerManufacturer(beerItemElement));

		return tradeBrandBeerData;
	}

	/**
	 * @param beerItemElement
	 * @return
	 * @throws DOMException
	 */
	private static String getParsedBeerManufacturer(Element beerItemElement) throws DOMException {
		Element elemManufacturer = DOMBeerItemsParser.getChildElement(beerItemElement, "manufacturer");
		String beerManufacturer = elemManufacturer.getTextContent();

		return beerManufacturer;
	}

	/**
	 * @param beerItemElement
	 * @return
	 * @throws DOMException
	 */
	private static String getParsedBeerSortType(Element beerItemElement) throws DOMException {
		Element elemSortType = DOMBeerItemsParser.getChildElement(beerItemElement, "sort-type");
		String beerSortType = elemSortType.getTextContent();

		return beerSortType;
	}

	/**
	 * @param beerItemElement
	 * @return
	 * @throws DOMException
	 */
	private static String getParsedBeerName(Element beerItemElement) throws DOMException {
		Element elemName = DOMBeerItemsParser.getChildElement(beerItemElement, "name");
		String beerName = elemName.getTextContent();

		return beerName;
	}

	/**
	 * Returns parsed beer ID.
	 * 
	 * @param beerItemElement
	 * @throws NumberFormatException
	 */
	private static int getParsedBeerID(Element beerItemElement) throws NumberFormatException {
		int beerId = Integer.parseInt(beerItemElement.getAttribute("beer-id"));
		return beerId;
	}

	/**
	 * Return's an child element of the parent element from parsed XML document
	 * tree.
	 * 
	 * @param parent
	 *            - an element of parsed XML document
	 * 
	 * @param childName
	 *            - a name of child element of parsed XML document
	 * @return a child element object
	 */
	private static Element getChildElement(Element parent, String childName) {
		NodeList nlist = parent.getElementsByTagName(childName);
		Element child = (Element) nlist.item(0);
		return child;
	}

}
