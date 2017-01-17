package by.beeritems.xml.parsers.stax;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.beer.entities.beeritem.BeerItem;
import by.beer.entities.beeritem.beerdata.ChemicalComponentsComposition;
import by.beer.entities.beeritem.beerdata.TradeBrandBeerdata;
import by.beer.entities.beeritem.beerdata.chars.AlсoholBeverageСharacteristiсData;
import by.beer.entities.beeritem.beerdata.chars.PackageType;
import by.beer.entities.beeritem.beerdata.chars.SoftBeverageСharacteristiсData;

/**
 * Class {@code StAXBeerItemsParser} provides methods to parse and transfer an XML document with information for {@code BeerItem} objects 
 * Also provides methods to initialize the fields for {@code BeerItem} objects
 * 
 * @author Igor Shurupov
 */
public class StAXBeerItemsParser {

	private List<BeerItem> beerItems = new ArrayList<>();
	private XMLInputFactory inputFactory;

	public enum BeerItemEnum {
		BEER_ITEMS, BEER, NAME, SORT_TYPE, MANUFACTURER, INGREDIENTS, WATER, SUGAR, HOP, MALT, YEAST, ALCOHOL, CHARS, BEER_CLARITY, IS_FILTERED, FOOD_VALUE, PACKAGING_TYPE, PACKAGE_CAPACITY, PACKAGE_MATERIAL
	}

	public StAXBeerItemsParser() {
		inputFactory = XMLInputFactory.newInstance();
	}
	
	/**
	 * Returns a list of {@code BeerItem} objects from parsed XML document
	 * 
	 * @return a list of {@code BeerItem} objects
	 */
	public List<BeerItem> getBeerItems() {
		return beerItems;
	}

	/**
	 * Builds a list of {@code BeerItem} objects from parsed XML document
	 * 
	 * @param fileName - is XML document
	 */
	public void buildListBeerItems(String fileName) {
		FileInputStream inputStream = null;
		XMLStreamReader reader = null;
		String name;
		try {
			inputStream = new FileInputStream(new File(fileName));
			reader = inputFactory.createXMLStreamReader(inputStream);
			while (reader.hasNext()) {
				int type = reader.next();
				if (type == XMLStreamConstants.START_ELEMENT) {
					name = reader.getLocalName();
					if (BeerItemEnum.valueOf(name.toUpperCase().replace('-', '_')) == BeerItemEnum.BEER) {
						BeerItem beerItem = buildBeerItem(reader);
						beerItems.add(beerItem);
					}
				}
			}
		} catch (XMLStreamException e) {
			System.err.println("StAX parsing error! " + e.getMessage());
		} catch (FileNotFoundException e) {
			System.err.println("File " + fileName + " not found! " + e);
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				System.err.println("Impossible close file " + fileName + ": " + e);
			}
		}
	}

	/**
	 * Returns an initialized {@code BeerItem} object by data from parsed XML document
	 * 
	 * @param reader - an XMLStreamReader object
	 * 
	 * @return a new {@code BeerItem} object
	 */
	private BeerItem buildBeerItem(XMLStreamReader reader) throws XMLStreamException {
		BeerItem beerItem = new BeerItem();
		TradeBrandBeerdata tradeBrandBeerData = new TradeBrandBeerdata();
		beerItem.setBeerId(Integer.parseInt(reader.getAttributeValue(0)));
		String name;
		while (reader.hasNext()) {
			int type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				name = reader.getLocalName();
				switch (BeerItemEnum.valueOf(name.toUpperCase().replace('-', '_'))) {
				case NAME:
					tradeBrandBeerData.setBeerName(getXMLText(reader));
					break;
				case SORT_TYPE:
					tradeBrandBeerData.setSortBeerType(getXMLText(reader));
					break;
				case MANUFACTURER:
					tradeBrandBeerData.setManufacturerBeerName(getXMLText(reader));
					break;
				case INGREDIENTS:
					beerItem.setChemicalComposition(getXMLChemicalComponentsComposition(reader));
					break;
				case ALCOHOL:
					beerItem.setAlcoholBeerType(getXMLText(reader));
					break;
				case CHARS:
					if (reader.getAttributeCount() == 0) {
						beerItem.setCharsData(getXMLSoftBeverageCharacteristicData(reader));
					} else {
						beerItem.setCharsData(getXMLAlcoholBeverageCharacteristicData(reader));
					}
					break;
				default:
					break;
				}
				break;
			case XMLStreamConstants.END_ELEMENT:
				name = reader.getLocalName();
				if (BeerItemEnum.valueOf(name.toUpperCase().replace('-', '_')) == BeerItemEnum.BEER) {
					beerItem.setBrandData(tradeBrandBeerData);
					return beerItem;
				}
				break;
			}
		}
		throw new XMLStreamException("Unknown element in tag Beer");
	}

	/**
	 * Returns an initialized {@code ChemicalComponentsComposition} object by data from parsed XML document
	 * 
	 * @param reader - an XMLStreamReader object
	 * 
	 * @return a new {@code ChemicalComponentsComposition} object
	 * 
	 * @throws XMLStreamException
	 */
	private ChemicalComponentsComposition getXMLChemicalComponentsComposition(XMLStreamReader reader)
			throws XMLStreamException {
		ChemicalComponentsComposition chemicalComponentsComposition = new ChemicalComponentsComposition();
		int type;
		String name;
		while (reader.hasNext()) {
			type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				name = reader.getLocalName();
				switch (BeerItemEnum.valueOf(name.toUpperCase().replace('-', '_'))) {
				case WATER:
					chemicalComponentsComposition.setWaterСapacity(Integer.parseInt(getXMLText(reader)));
					break;
				case SUGAR:
					chemicalComponentsComposition.setSugarСapacity(Integer.parseInt(getXMLText(reader)));
					break;
				case HOP:
					chemicalComponentsComposition.setHopСapacity(Integer.parseInt(getXMLText(reader)));
					break;
				case MALT:
					chemicalComponentsComposition.setMaltСapacity(Integer.parseInt(getXMLText(reader)));
					break;
				case YEAST:
					chemicalComponentsComposition.setYeastСapacity(Integer.parseInt(getXMLText(reader)));
					break;
				default:
					break;
				}
				break;
			case XMLStreamConstants.END_ELEMENT:
				name = reader.getLocalName();
				if (BeerItemEnum.valueOf(name.toUpperCase().replace('-', '_')) == BeerItemEnum.INGREDIENTS) {
					return chemicalComponentsComposition;
				}
				break;
			}
		}
		throw new XMLStreamException("Unknown element in tag Ingredients");
	}

	/**
	 * Returns an initialized {@code AlcoholBeverageCharacteristicData} object by data from parsed XML document
	 * 
	 * @param reader - an XMLStreamReader object
	 * 
	 * @return a new {@code AlcoholBeverageCharacteristicData} object
	 * 
	 * @throws XMLStreamException
	 */
	private AlсoholBeverageСharacteristiсData getXMLAlcoholBeverageCharacteristicData(XMLStreamReader reader)
			throws XMLStreamException {
		AlсoholBeverageСharacteristiсData alcoholBeverageCharacteristicData = new AlсoholBeverageСharacteristiсData();
		int type;
		String name;
		alcoholBeverageCharacteristicData.setAlcoholVolume(Float.parseFloat(reader.getAttributeValue(0)));
		while (reader.hasNext()) {
			type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				name = reader.getLocalName();
				switch (BeerItemEnum.valueOf(name.toUpperCase().replace('-', '_'))) {
				case BEER_CLARITY:
					alcoholBeverageCharacteristicData.setBeerClarity(Integer.parseInt(getXMLText(reader)));
					break;
				case IS_FILTERED:
					alcoholBeverageCharacteristicData.setFiltered(Boolean.parseBoolean(getXMLText(reader)));
					break;
				case FOOD_VALUE:
					alcoholBeverageCharacteristicData.setFoodValue(Float.parseFloat(getXMLText(reader)));
					break;
				case PACKAGING_TYPE:
					alcoholBeverageCharacteristicData.setPackageType(getXMLPackageType(reader));
					break;
				default:
					break;
				}
				break;
			case XMLStreamConstants.END_ELEMENT:
				name = reader.getLocalName();
				if (BeerItemEnum.valueOf(name.toUpperCase().replace('-', '_')) == BeerItemEnum.CHARS) {
					return alcoholBeverageCharacteristicData;
				}
				break;
			}
		}
		throw new XMLStreamException("Unknown element in tag Chars");
	}

	/**
	 * Returns an initialized {@code SoftBeverageCharacteristicData} object by data from parsed XML document
	 * 
	 * @param reader - an XMLStreamReader object
	 * 
	 * @return a new {@code SoftBeverageCharacteristicData} object
	 * 
	 * @throws XMLStreamException
	 */
	private SoftBeverageСharacteristiсData getXMLSoftBeverageCharacteristicData(XMLStreamReader reader)
			throws XMLStreamException {
		SoftBeverageСharacteristiсData softBeverageCharacteristicData = new SoftBeverageСharacteristiсData();
		int type;
		String name;
		while (reader.hasNext()) {
			type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				name = reader.getLocalName();
				switch (BeerItemEnum.valueOf(name.toUpperCase().replace('-', '_'))) {
				case BEER_CLARITY:
					softBeverageCharacteristicData.setBeerClarity(Integer.parseInt(getXMLText(reader)));
					break;
				case IS_FILTERED:
					softBeverageCharacteristicData.setFiltered(Boolean.parseBoolean(getXMLText(reader)));
					break;
				case FOOD_VALUE:
					softBeverageCharacteristicData.setFoodValue(Float.parseFloat(getXMLText(reader)));
					break;
				case PACKAGING_TYPE:
					softBeverageCharacteristicData.setPackageType(getXMLPackageType(reader));
					break;
				default:
					break;
				}
				break;
			case XMLStreamConstants.END_ELEMENT:
				name = reader.getLocalName();
				if (BeerItemEnum.valueOf(name.toUpperCase().replace('-', '_')) == BeerItemEnum.CHARS) {
					return softBeverageCharacteristicData;
				}
				break;
			}
		}
		throw new XMLStreamException("Unknown element in tag Chars");
	}

	/**
	 * Returns an initialized {@code PackageType} object by data from parsed XML document
	 * 
	 * @param reader - an XMLStreamReader object
	 * 
	 * @return a new {@code PackageType} object
	 * 
	 * @throws XMLStreamException
	 */
	private PackageType getXMLPackageType(XMLStreamReader reader) throws XMLStreamException {
		PackageType packageType = new PackageType();
		int type;
		String name;
		while (reader.hasNext()) {
			type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				name = reader.getLocalName();
				switch (BeerItemEnum.valueOf(name.toUpperCase().replace('-', '_'))) {
				case PACKAGE_CAPACITY:
					packageType.setPackageCapacity(Float.parseFloat(getXMLText(reader)));
					break;
				case PACKAGE_MATERIAL:
					packageType.setPackageMaterial(getXMLText(reader));
					break;
				default:
					break;
				}
				break;
			case XMLStreamConstants.END_ELEMENT:
				name = reader.getLocalName();
				if (BeerItemEnum.valueOf(name.toUpperCase().replace('-', '_')) == BeerItemEnum.PACKAGING_TYPE) {
					return packageType;
				}
				break;
			}
		}
		throw new XMLStreamException("Unknown element in tag Packaging Type");
	}
	
	/**
	 * Returns text from parsed XML file
	 * 
	 * @param reader - an XMLStreamReader object
	 * 
	 * @return text from parsed XML file
	 * 
	 * @throws XMLStreamException
	 */
	private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
		String text = null;
		if (reader.hasNext()) {
			reader.next();
			text = reader.getText();
		}
		return text;
	}

}
