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
import by.beer.entities.beeritem.beerdata.chars.PackageType;
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
	private int beerClarity;
	private boolean isFiltered;
	private float foodValue;
	// ---PackageType
	private PackageType packageType;
	private float packageCapacity;
	private String packageMaterial;
	// ----------------------------------
	// --------------------------------------------

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
			currentElement = "localName";
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

		default: {
			break;
		}

		}

	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {

		String elementDataFromXML = new String(ch, start, length).trim();

		if (this.currentBeerName.equals("") && currentElement.equals("name")) {

			this.currentBeerName = elementDataFromXML;
		}

		else if (this.currentSortBeerType.equals("") && currentElement.equals("sort-type")) {

			this.currentSortBeerType = elementDataFromXML;
		}

		else if (this.currentManufacturerBeerName.equals("") && currentElement.equals("manufacturer")) {

			this.currentManufacturerBeerName = elementDataFromXML;
		}

		else if ((currentWaterСapacity == 0) && currentElement.equals("water")) {

			this.currentWaterСapacity = Integer.parseInt(elementDataFromXML);

		}

		else if ((currentSugarСapacity == 0) && this.currentElement.equals("sugar")) {

			this.currentSugarСapacity = Integer.parseInt(elementDataFromXML);

		}

		else if ((currentHopСapacity == 0) && this.currentElement.equals("hop")) {

			this.currentHopСapacity = Integer.parseInt(elementDataFromXML);

		}

		else if ((currentMaltСapacity == 0) && this.currentElement.equals("malt")) {

			this.currentMaltСapacity = Integer.parseInt(elementDataFromXML);

		}

		else if ((currentYeastСapacity == 0) && this.currentElement.equals("yeast")) {

			this.currentYeastСapacity = Integer.parseInt(elementDataFromXML);

		}

		else if (currentAlcoholBeerType.equals("") && this.currentElement.equals("alcohol")) {

			this.currentAlcoholBeerType = elementDataFromXML;

		}

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		switch (localName) {

		case "manufacturer": {
			initCurrentBrandData(this.currentBeerName, this.currentSortBeerType, this.currentManufacturerBeerName);
			break;

		}

		case "yeast": {
			initChemicalComponentsComposition(this.currentWaterСapacity, currentSugarСapacity, currentHopСapacity,
					currentMaltСapacity, currentYeastСapacity);
			break;
		}
		
		case "alcohol":{
			
			showBeer();
			clearFields();
			break;
		}

		}

	}

	private void showBeer() {

		System.out.println("ID " + this.currentBeerId);
		System.out.println(this.currentBrandData);
		System.out.println(this.currentChemicalComposition);
		System.out.println(this.currentAlcoholBeerType);

		System.out.println("--------------------------------------");

	}

	private void clearFields() {

		this.currentBeerId = 0;
		
		this.currentBeerName = "";
		this.currentSortBeerType = "";
		this.currentManufacturerBeerName = "";
		
		this.currentWaterСapacity = 0;
		this.currentSugarСapacity = 0;
		this.currentHopСapacity = 0;
		this.currentMaltСapacity = 0;
		
		this.currentYeastСapacity = 0;
		
		this.currentAlcoholBeerType = "";

		currentElement = "";

	}

	/**
	 * Initializes a {@code ChemicalComponentsComposition} field for a new
	 * {@code BeerItem} object.
	 * 
	 * 
	 * @param waterСapacity
	 *            - a parsed value of water capacity for a new {@code BeerItem}
	 *            object
	 * 
	 * @param sugarСapacity
	 *            - a parsed value of sugar capacity for a new {@code BeerItem}
	 *            object
	 * 
	 * @param hopСapacity
	 *            - a parsed value of hop capacity for a new {@code BeerItem}
	 *            object
	 * 
	 * @param maltСapacity
	 *            - a parsed value of malt capacity for a new {@code BeerItem}
	 *            object
	 * 
	 * @param yeastСapacity
	 *            - a parsed value of yeast capacity for a new {@code BeerItem}
	 *            object
	 * 
	 * @see BeerItem
	 * @see ChemicalComponentsComposition
	 * 
	 */
	private void initChemicalComponentsComposition(int waterСapacity, int sugarСapacity, int hopСapacity,
			int maltСapacity, int yeastСapacity) {

		this.currentChemicalComposition = new ChemicalComponentsComposition(waterСapacity, sugarСapacity, hopСapacity,
				maltСapacity, yeastСapacity);

	}

	/**
	 * Initializes a {@code TradeBrandBeerdata} field for a new {@code BeerItem}
	 * object.
	 * 
	 * 
	 * @param beerName
	 *            - a parsed name for a new {@code BeerItem} object
	 * 
	 * @param sortBeerType
	 *            - a parsed sort type for a new {@code BeerItem} object
	 * 
	 * @param manufacturerBeerName
	 *            - a parsed manufacturer name for a new {@code BeerItem} object
	 * 
	 * @see BeerItem
	 * @see TradeBrandBeerdata
	 */
	private void initCurrentBrandData(String beerName, String sortBeerType, String manufacturerBeerName) {

		this.currentBrandData = new TradeBrandBeerdata(beerName, manufacturerBeerName, sortBeerType);

	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
	}

}
