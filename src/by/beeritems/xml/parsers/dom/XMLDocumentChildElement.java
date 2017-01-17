package by.beeritems.xml.parsers.dom;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Class {@code XMLDocumentChildElement} provides method to get a child element
 * from XML document by it's name and parent element object.
 * 
 * @author Dmitry Zyablov
 * 
 *
 */
public class XMLDocumentChildElement {

	/**
	 * Return's an child element of the parent element from parsed XML document
	 * tree.
	 * 
	 * @param parent
	 *            - a parent element of parsed XML document for seeking child
	 *            element
	 * 
	 * @param childName
	 *            - a name of child element of parsed XML document
	 * 
	 * @return a child element object of XML document
	 */
	protected static Element getChildElement(Element parent, String childName) {
		NodeList nlist = parent.getElementsByTagName(childName);
		Element child = (Element) nlist.item(0);
		return child;
	}

	private XMLDocumentChildElement() {
	}

}