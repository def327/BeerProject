package by.beeritems.xml.parsers.sax;

import java.util.LinkedList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import by.beer.entities.beeritem.BeerItem;
import by.beer.entities.beeritem.beerdata.ChemicalComponentsComposition;
import by.beer.entities.beeritem.beerdata.TradeBrandBeerdata;
import by.beer.entities.beeritem.beerdata.chars.AlсoholBeverageСharacteristiсData;
import by.beer.entities.beeritem.beerdata.chars.PackageType;
import by.beer.entities.beeritem.beerdata.chars.SoftBeverageСharacteristiсData;
import by.beer.entities.beeritem.beerdata.chars.СharacteristiсData;

/**
 * Class {@code SAXBeerItemsParser} provides method to parse and transfer an XML
 * document with information for {@code BeerItem} objects. Also provides methods
 * to initialize the fields for {@code BeerItem} objects.
 * 
 * @author Dmitry Zyablov
 * 
 * @see BeerItem
 *
 */
public class SAXBeerItemsParser extends DefaultHandler {

	private String currentElement;

	private static int BEER_ID = 0;
	private static int ALCOHOL_VOLUME = 0;

	// -- BeerItem container
	private List<BeerItem> beerItemList;
	// --------------------------------------

	// --Beer ID
	private int currentBeerId;
	// --------------------------------------

	// --TradeBrandBeerdata
	private TradeBrandBeerdata currentBrandData;
	private String currentBeerName;
	private String currentManufacturerBeerName;
	private String currentSortBeerType;
	// --------------------------------------

	// --ChemicalComponentsComposition
	private ChemicalComponentsComposition currentChemicalComposition;
	private int currentWaterСapacity;
	private int currentSugarСapacity;
	private int currentHopСapacity;
	private int currentMaltСapacity;
	private int currentYeastСapacity;
	// --------------------------------------

	// --AlcoholBeerType
	private String currentAlcoholBeerType;
	// --------------------------------------

	// --СharacteristiсData
	private СharacteristiсData currentCharsData;
	private int currentBeerClarity;
	private boolean currentIsFiltered;
	private float currentFoodValue;
	private float currentAlcoholVolume;
	// ----------------------------------------
	// ---PackageType
	private PackageType currentPackageType;
	private float currentPackageCapacity;
	private String currentPackageMaterial;
	// --------------------------------------

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		switch (localName) {

		case "beer": {
			currentElement = localName;
			this.currentBeerId = Integer.parseInt(attributes.getValue(BEER_ID));
			break;
		}

		case "name": {
			currentElement = localName;
			break;
		}

		case "sort-type": {
			currentElement = localName;
			break;
		}

		case "manufacturer": {
			currentElement = localName;
			break;
		}

		case "ingredients": {
			currentElement = localName;
			break;
		}

		case "water": {
			currentElement = localName;
			break;
		}

		case "sugar": {
			currentElement = localName;
			break;
		}

		case "hop": {
			currentElement = localName;
			break;
		}

		case "malt": {
			currentElement = localName;
			break;
		}

		case "yeast": {
			currentElement = localName;
			break;
		}

		case "alcohol": {
			currentElement = localName;
			break;
		}

		case "chars": {
			currentElement = localName;

			if (this.currentAlcoholBeerType.equals("alcoholic beverage")) {
				this.currentAlcoholVolume = Float.parseFloat(attributes.getValue(ALCOHOL_VOLUME));
			}
			break;
		}

		case "beer-clarity": {
			currentElement = localName;
			break;
		}

		case "is-filtered": {
			currentElement = localName;
			break;
		}

		case "food-value": {
			currentElement = localName;
			break;
		}

		case "package-capacity": {
			currentElement = localName;
			break;
		}

		case "package-material": {
			currentElement = localName;
			break;
		}

		default: {
			break;
		}

		}

	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {

		String elementDataFromXML = new String(ch, start, length).trim();

		if (elementDataFromXML.isEmpty()) {

			return;

		} else {

			switch (currentElement) {

			case "name": {
				this.currentBeerName = elementDataFromXML;
				break;
			}

			case "sort-type": {
				this.currentSortBeerType = elementDataFromXML;
				break;
			}

			case "manufacturer": {
				this.currentManufacturerBeerName = elementDataFromXML;
				break;
			}

			case "water": {
				this.currentWaterСapacity = Integer.parseInt(elementDataFromXML);
				break;
			}

			case "sugar": {
				this.currentSugarСapacity = Integer.parseInt(elementDataFromXML);
				break;
			}

			case "hop": {
				this.currentHopСapacity = Integer.parseInt(elementDataFromXML);
				break;
			}

			case "malt": {
				this.currentMaltСapacity = Integer.parseInt(elementDataFromXML);
				break;

			}

			case "yeast": {
				this.currentYeastСapacity = Integer.parseInt(elementDataFromXML);
				break;

			}

			case "alcohol": {
				this.currentAlcoholBeerType = elementDataFromXML;
				break;
			}

			case "beer-clarity": {
				this.currentBeerClarity = Integer.parseInt(elementDataFromXML);
				break;
			}

			case "is-filtered": {
				this.currentIsFiltered = Boolean.parseBoolean(elementDataFromXML);
				break;
			}

			case "food-value": {
				this.currentFoodValue = Float.parseFloat(elementDataFromXML);
				break;
			}

			case "package-capacity": {
				this.currentPackageCapacity = Float.parseFloat(elementDataFromXML);
				break;
			}

			case "package-material": {
				this.currentPackageMaterial = elementDataFromXML;
				break;
			}

			default: {
				break;
			}

			}

		}

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		switch (localName) {

		case "manufacturer": {
			initCurrentBrandData();
			break;
		}

		case "ingredients": {
			initChemicalComponentsComposition();
			break;
		}

		case "packaging-type": {
			initPackageType(currentPackageCapacity, currentPackageMaterial);
			break;
		}

		case "chars": {
			initСharacteristiсData();
			break;
		}

		case "beer": {
			addParsedBeerItemObjectToList();
			break;
		}

		default: {
			break;
		}

		}
	}

	/**
	 * Initializes a {@code СharacteristiсData} field for a new {@code BeerItem}
	 * object.
	 * 
	 * 
	 * @see BeerItem
	 * @see СharacteristiсData
	 * @see AlсoholBeverageСharacteristiсData
	 * @see SoftBeverageСharacteristiсData
	 */
	private void initСharacteristiсData() {

		if (this.currentAlcoholBeerType.equals("alcoholic beverage")) {

			this.currentCharsData = new AlсoholBeverageСharacteristiсData(this.currentBeerClarity,
					this.currentIsFiltered, this.currentFoodValue, this.currentPackageType, this.currentAlcoholVolume);

		} else {

			this.currentCharsData = new SoftBeverageСharacteristiсData(currentBeerClarity, currentIsFiltered,
					currentFoodValue, currentPackageType);

		}

	}

	/**
	 * Initializes a {@code PackageType} field for a new {@code BeerItem}
	 * object.
	 * 
	 * 
	 * @see BeerItem
	 * @see PackageType
	 * 
	 */
	private void initPackageType(float packageCapacity, String packageMaterial) {
		this.currentPackageType = new PackageType(packageCapacity, packageMaterial);
	}

	/**
	 * Initializes a {@code ChemicalComponentsComposition} field for a new
	 * {@code BeerItem} object.
	 * 
	 * 
	 * 
	 * @see BeerItem
	 * @see ChemicalComponentsComposition
	 * 
	 */
	private void initChemicalComponentsComposition() {
		this.currentChemicalComposition = new ChemicalComponentsComposition(this.currentWaterСapacity,
				this.currentSugarСapacity, this.currentHopСapacity, this.currentMaltСapacity,
				this.currentYeastСapacity);
	}

	/**
	 * Initializes a {@code TradeBrandBeerdata} field for a new {@code BeerItem}
	 * object.
	 * 
	 * 
	 * 
	 * @see BeerItem
	 * @see TradeBrandBeerdata
	 */
	private void initCurrentBrandData() {
		this.currentBrandData = new TradeBrandBeerdata(this.currentBeerName, this.currentManufacturerBeerName,
				this.currentSortBeerType);
	}

	/**
	 * Initializes all fields of a new {@code BeerItem} object and add it to a
	 * list of {@code BeerItem} objects.
	 * 
	 * @see BeerItem
	 * 
	 */
	private void addParsedBeerItemObjectToList() {

		// Initializing fields of a new BeerItem by inner Class
		BeerItem newBeerItem = new BeerItem.BuilderBeerItem().beerId(this.currentBeerId)
				.brandData(this.currentBrandData).chemicalComposition(this.currentChemicalComposition)
				.alcoholBeerType(this.currentAlcoholBeerType).charsData(this.currentCharsData).newInstance();

		beerItemList.add(newBeerItem);
	}

	/**
	 * Constructs a default <code>SAXBeerItemsParser</code> object and
	 * initialize a container for {@code BeerItem} objects.
	 * 
	 * @see BeerItem
	 */
	public SAXBeerItemsParser() {
		beerItemList = new LinkedList<>();
	}

	/**
	 * @return the beerItemList
	 */
	public List<BeerItem> getBeerItemList() {
		return beerItemList;
	}

	/**
	 * @param beerItemList
	 *            the beerItemList to set
	 */
	public void setBeerItemList(List<BeerItem> beerItemList) {
		this.beerItemList = beerItemList;
	}

}
