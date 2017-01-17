package by.beer.menu.comands;

import java.util.Scanner;

import by.beer.entities.interfaces.Receiveriable;

public abstract class Receiver implements Receiveriable {

	/**
	 * An input stream for console.
	 */
	protected Scanner consoleScaner;

	/**
	 * Constructs <code>ReceiverExitProgram</code> based om {@code Scanner}
	 * object.
	 * 
	 * @param consoleScaner
	 *            - a input stream for console.
	 * 
	 */
	public Receiver(Scanner consoleScaner) {
		this.consoleScaner = consoleScaner;
	}

}