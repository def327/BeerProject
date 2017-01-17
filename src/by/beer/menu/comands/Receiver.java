package by.beer.menu.comands;

import java.util.Scanner;

import by.beer.entities.beeritem.manager.ManagerBeerItem;
import by.beer.entities.interfaces.Receiveriable;

/**
 * Class {@code Receiver} realizes a user command.
 * 
 * @author Дмитрий Зяблов
 * 
 * @see Receiveriable
 *
 */
public abstract class Receiver implements Receiveriable {

	/**
	 * An input stream for console.
	 */
	protected Scanner consoleScaner;

	/**
	 * A storage for the list of {@code BeerItem} objects.
	 */
	protected ManagerBeerItem manager;

	/**
	 * Constructs <code>ReceiverExitProgram</code> based om {@code Scanner}
	 * object.
	 * 
	 * @param consoleScaner
	 *            - a input stream for console.
	 * 
	 * @param manager
	 *            - a storage for a list of {@code BeerItem} objects.
	 * 
	 */
	public Receiver(Scanner consoleScaner, ManagerBeerItem manager) {
		this.consoleScaner = consoleScaner;
		this.manager = manager;
	}

}