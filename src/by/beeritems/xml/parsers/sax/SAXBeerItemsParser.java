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
	private String currentAlcoholBeerType;
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

		if (localName.equals("beer")) {

			// System.out.println("StartElement" + "--" + localName);

			currentElement = localName;
			this.currentBeerId = Integer.parseInt(attributes.getValue(0));

		} else if (localName.equals("name")) {

			// System.out.println("StartElement" + "--" + localName);

			currentElement = localName;

		} else if (localName.equals("sort-type")) {

			// System.out.println("StartElement" + "--" + localName);

			currentElement = localName;

		} else if (localName.equals("manufacturer")) {

			// System.out.println("StartElement" + "--" + localName);

			currentElement = localName;

		} else if (localName.equals("ingredients")) {

			// System.out.println("StartElement" + "--" + localName);

			currentElement = "localName";

		} else if (localName.equals("water")) {

			// System.out.println("StartElement" + "--" + localName);

			currentElement = localName;

		} else if (localName.equals("sugar")) {

			// System.out.println("StartElement" + "--" + localName);

			currentElement = localName;

		} else if (localName.equals("hop")) {

			// System.out.println("StartElement" + "--" + localName);

			currentElement = localName;

		} else if (localName.equals("malt")) {

			// System.out.println("StartElement" + "--" + localName);

			currentElement = localName;

		} else if (localName.equals("yeast")) {

			// System.out.println("StartElement" + "--" + localName);

			currentElement = localName;

		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {

		String elementDataFromXML = new String(ch, start, length).trim();

		if (this.currentBeerName.equals("") && currentElement.equals("name")) {

			// System.out.println("Characters" + "--" + currentElement + "--" +
			// elementDataFromXML);

			this.currentBeerName = elementDataFromXML;

		}

		else if (this.currentSortBeerType.equals("") && currentElement.equals("sort-type")) {

			// System.out.println("Characters" + "--" + currentElement + "--" +
			// elementDataFromXML);

			this.currentSortBeerType = elementDataFromXML;
		}

		else if (this.currentManufacturerBeerName.equals("") && currentElement.equals("manufacturer")) {

			// System.out.println("Characters" + "--" + currentElement + "--" +
			// elementDataFromXML);

			this.currentManufacturerBeerName = elementDataFromXML;
		}

		else if ((currentWaterСapacity == 0) && currentElement.equals("water")) {

			// System.out.println("Characters" + "--" + currentElement + "--" +
			// elementDataFromXML);

			this.currentWaterСapacity = Integer.parseInt(elementDataFromXML);

		}

		else if ((currentSugarСapacity == 0) && this.currentElement.equals("sugar")) {

			// System.out.println("Characters" + "--" + currentElement + "--" +
			// elementDataFromXML);

			this.currentSugarСapacity = Integer.parseInt(elementDataFromXML);

		}

		else if ((currentHopСapacity == 0) && this.currentElement.equals("hop")) {

			// System.out.println("Characters" + "--" + currentElement + "--" +
			// elementDataFromXML);

			this.currentHopСapacity = Integer.parseInt(elementDataFromXML);

		}

		else if ((currentMaltСapacity == 0) && this.currentElement.equals("malt")) {

//			 System.out.println("Characters" + "--" + currentElement + "--" +
//			 elementDataFromXML);

			this.currentMaltСapacity = Integer.parseInt(elementDataFromXML);

		}

		else if ((currentYeastСapacity == 0) && this.currentElement.equals("yeast")) {

			// System.out.println("Characters" + "--" + currentElement + "--" +
			// elementDataFromXML);

			this.currentYeastСapacity = Integer.parseInt(elementDataFromXML);

		}

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		// System.out.println("EndElement" + "--" + currentElement);

		if (localName.equals("manufacturer")) {

			initCurrentBrandData(this.currentBeerName, this.currentSortBeerType, this.currentManufacturerBeerName);

		}

		else if (localName.equals("yeast")) {
			
			initChemicalComponentsComposition(this.currentWaterСapacity, currentSugarСapacity, currentHopСapacity, currentMaltСapacity, currentYeastСapacity);

			System.out.println("ID " + this.currentBeerId);
			System.out.println(this.currentBrandData);
			System.out.println(this.currentChemicalComposition);
			

			

			System.out.println("--------------------------------------");

			this.currentBeerId = 0;
			this.currentBeerName = "";
			this.currentSortBeerType = "";
			this.currentManufacturerBeerName = "";
			this.currentWaterСapacity = 0;
			this.currentSugarСapacity = 0;
			this.currentHopСapacity = 0;
			this.currentMaltСapacity = 0;
			this.currentYeastСapacity = 0;

			currentElement = "";
		}

	}

	private void initChemicalComponentsComposition(int waterСapacity, int sugarСapacity, int hopСapacity,
			int maltСapacity, int yeastСapacity) {

		this.currentChemicalComposition = new ChemicalComponentsComposition(waterСapacity, sugarСapacity, hopСapacity,
				maltСapacity, yeastСapacity);

	}

	/**
	 * Initializes a {@code TradeBrandBeerdata} object for a new
	 * {@code BeerItem} object.
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
