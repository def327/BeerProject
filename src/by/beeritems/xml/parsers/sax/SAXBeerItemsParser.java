package by.beeritems.xml.parsers.sax;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

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

	private String currentElement = "";

	// -- BeerItem container
	private List<BeerItem> beerItemList = new LinkedList<>();
	// --------------------------------------

	// --Beer ID
	private int currentBeerId = 0;
	// --------------------------------------

	// --TradeBrandBeerdata
	private TradeBrandBeerdata currentBrandData = null;
	private String currentBeerName = "";
	private String currentManufacturerBeerName = "";
	private String currentSortBeerType = "";
	// --------------------------------------

	// --ChemicalComponentsComposition
	private ChemicalComponentsComposition currentChemicalComposition;
	private int currentWaterСapacity = 0;
	private int currentSugarСapacity = 0;
	private int currentHopСapacity = 0;
	private int currentMaltСapacity = 0;
	private int currentYeastСapacity = 0;
	// --------------------------------------

	// --AlcoholBeerType
	private String currentAlcoholBeerType = "";
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

	public static void main(String[] args) {

		SAXBeerItemsParser hundler = new SAXBeerItemsParser();
		XMLReader reader;

		try {

			reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(hundler);
			reader.parse("xml//BeerItems.xml");

		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		switch (localName) {

		case "beer": {
			currentElement = localName;
			this.currentBeerId = Integer.parseInt(attributes.getValue(0));
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
				this.currentAlcoholVolume = Float.parseFloat(attributes.getValue(0));
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

	private void addParsedBeerItemObjectToList() {
		
		
		
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

	private void showBeer() {

		System.out.println("ID " + this.currentBeerId);
		System.out.println(this.currentBrandData);
		System.out.println(this.currentChemicalComposition);
		System.out.println(this.currentAlcoholBeerType);
		System.out.println(this.currentCharsData);

		System.out.println("--------------------------------------");

	}

}
