
package by.beer;

import by.beer.usermenu.SingleApplicationMenu;

/**
 * 
 * <h1>BeerXMLProjectRunner</h1>
 * <p>
 * "BeerXMLProject" program is a console application, where user can load data
 * from XML file about beer items by parsers: StAX, SAX and DOM.
 * 
 * @author Дмитрий Зяблов
 * @version 1.0
 * @since 2016
 */
public class BeerXMLProjectRunner {

	/**
	 * Creates and runs an aplication's menu for program user to start to use
	 * app.
	 * <p>
	 * <i>The entry point of the program</i>
	 * 
	 * @param args
	 *            Unused.
	 * @return Nothing
	 * 
	 * @see SingleApplicationMenu
	 * 
	 */
	public static void main(String[] args) {
		SingleApplicationMenu menu = SingleApplicationMenu.getInstance();
		menu.runAppMenu();
	}

}
