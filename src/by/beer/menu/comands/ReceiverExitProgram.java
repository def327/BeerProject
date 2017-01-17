package by.beer.menu.comands;

import java.util.Scanner;

import by.beer.entities.beeritem.manager.ManagerBeerItem;
import by.beer.resources.ResourceBundleManager;

/**
 * Class {@code ReceiverExitProgram} realizes a user command to exit the
 * program.
 * 
 * @author Dmitry Zyablov
 * 
 * @see Receiver
 *
 */
public class ReceiverExitProgram extends Receiver {

	/**
	 * Exit the program.
	 * 
	 */
	@Override
	public void action() {
		System.out.println(ResourceBundleManager.getProperty("menu.exit"));

		// Close resources
		consoleScaner.close();

		// Exit program successfully
		System.exit(0);
	}

	/**
	 * Constructs <code>ReceiverExitProgram</code> based om {@code Scanner}
	 * object.
	 * 
	 * @param consoleScaner
	 *            - a input stream for console.
	 * @param manager
	 *            - a storage for a list of {@code BeerItem} objects.
	 * 
	 */
	public ReceiverExitProgram(Scanner consoleScaner, ManagerBeerItem manager) {
		super(consoleScaner, manager);
	}

}
