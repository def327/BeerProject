package by.beer.menu.comands;

import java.util.Scanner;

/**
 * Class {@code ReceiverExitProgram} realizes a user command to exit the
 * program.
 * 
 * @author Дмитрий Зяблов
 * 
 * @see Receiver
 *
 */
public class ReceiverExitProgram extends Receiver {

	/**
	 * Exit the program.
	 * 
	 * {@link Receiveriable#action() action()}
	 * 
	 */
	@Override
	public void action() {
		System.out.println("Exit the program!!!");

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
	 * 
	 */
	public ReceiverExitProgram(Scanner consoleScaner) {
		super(consoleScaner);
		// TODO Auto-generated constructor stub
	}

}
