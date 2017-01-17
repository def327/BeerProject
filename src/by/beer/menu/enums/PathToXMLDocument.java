package by.beer.menu.enums;

/**
 * Enum {@code PathToXMLDocument} holds a path to XML document in file system.
 * 
 * @author Дмитрий Зяблов
 * @version 1.0
 * @since 2016
 * 
 * 
 */
public enum PathToXMLDocument {

	PATH_TO_XML_DOCUMENT("xml//BeerItems.xml");

	/**
	 * Path to XML document.
	 */
	private String path;

	/**
	 * Constructor.
	 * 
	 * @param path
	 *            - a String value of path to get XML document for parsing.
	 */
	private PathToXMLDocument(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return (this.path);
	}

}
