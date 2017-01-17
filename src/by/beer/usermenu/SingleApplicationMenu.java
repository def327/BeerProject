package by.beer.usermenu;

import java.util.Scanner;

import by.beer.entities.interfaces.Commandable;
import by.beer.entities.interfaces.Receiveriable;
import by.beer.menu.comands.Command;
import by.beer.menu.comands.Invoker;
import by.beer.menu.comands.ReceiverExitProgram;
import by.beer.menu.comands.ReceiverLoadBeerItemsFromXML;
import by.beer.menu.comands.ReceiverShowSortedBeerItemList;

/**
 * Class {@code SingleApplicationMenuFactory} represents a menu for user via
 * console.
 * 
 * @author Дмитрий Зяблов
 *
 */
public class SingleApplicationMenu {

	/**
	 * A uniqiue sinagle instanse of {@code SingleApplicationMenuFactory} class.
	 */
	public static SingleApplicationMenu applicationMenuObject = new SingleApplicationMenu();

	/**
	 * Runs application by {@code SingleApplicationMenuFactory} object.
	 */
	public void runAppMenu() {

		// Create only one Scanner object for a whole menu
		Scanner inReader = new Scanner(System.in);

		// Create an invoker for commands to execute
		Invoker commandInvoker = new Invoker();

		while (true) {
			try {
				System.out.println("Menu started:");
				System.out.println("1 - Parse BeerItems from XML by StAx, SAX or DOM");
				System.out.println("2 - Sort and display BeerItems");
				System.out.println("3 - Exit program");

				String comandAction = inReader.nextLine();

				switch (comandAction) {
				case "1": {

					Receiveriable receiver = new ReceiverLoadBeerItemsFromXML(inReader);
					this.setCommandToExecute(commandInvoker, receiver);
					commandInvoker.executeCommand();

					break;
				}

				case "2": {

					Receiveriable receiver = new ReceiverShowSortedBeerItemList(inReader);
					this.setCommandToExecute(commandInvoker, receiver);
					commandInvoker.executeCommand();

					break;
				}

				case "3": {

					Receiveriable receiver = new ReceiverExitProgram(inReader);
					this.setCommandToExecute(commandInvoker, receiver);
					commandInvoker.executeCommand();

					break;
				}

				default: {
					System.out.println("Try again");
					// Ask user again
					continue;
				}
				}
			} catch (IllegalArgumentException e) {
				System.out.println("Try again");
				// Ask user again
				continue;
			}

		}

	}

	/**
	 * Sets a {@code ICommand} object with a receiver to execute command.
	 * 
	 * @param commandInvoker
	 *            - an invoker to set command
	 * 
	 * @param receiver
	 *            - a receiver of a command
	 */
	private void setCommandToExecute(Invoker commandInvoker, Receiveriable receiver) {
		Commandable command = new Command(receiver);
		commandInvoker.setCommand(command);
	}

	/**
	 * Return's a {@code SingleApplicationMenuFactory} reference object.
	 * 
	 * @return a SingleApplicationMenuFactory object
	 */
	public static SingleApplicationMenu getInstance() {
		return applicationMenuObject;
	}

	/**
	 * Default constructor for {@code SingleApplicationMenuFactory}
	 */
	private SingleApplicationMenu() {

	}

}
