
package by.beer.xml.parsers.builders;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import by.beer.entities.beeritem.BeerItem;
import by.beeritems.xml.parsers.dom.DOMBeerItemsParser;

/**
 * Class {@code BeerItemsDOMBuilder} can create a list of {@code BeerItem}
 * object's from XML file using
 * {@link BeerItemsDOMBuilder#buildListBeerItems(String)
 * buildListBeerItems()}method.
 * 
 * 
 * @author Дмитрий Зяблов
 * 
 * @see BeerItem
 * 
 *
 */
public class BeerItemsDOMBuilder extends AbstractBeerItemsBuilder {

	/**
	 * Returns a list of initialized {@code BeerItem} object's from XML file.
	 * 
	 * @param fileName
	 * @return a list if {@code BeerItem} objects -
	 */
	@Override
	public List<BeerItem> buildListBeerItems(String fileName) {

		try {
			// Get Document Builder
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();

			// Build Document
			Document document = builder.parse(new File(fileName));

			// Normalize the XML Structure
			document.getDocumentElement().normalize();

			// Here comes the root node
			Element root = document.getDocumentElement();
			this.beerItems = DOMBeerItemsParser.listBuilder(root);

		} catch (SAXException e) {
			System.out.println("Problem of parser" + e);
		} catch (ParserConfigurationException e) {
			System.err.println("Problem of parser configuration" + e);
		} catch (IOException e) {
			System.out.println("Problem of reading file" + fileName + "\n" + e);
		}
		return (this.beerItems);
	}

}
