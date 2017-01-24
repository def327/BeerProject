package by.beer.usermenu;

import java.util.Scanner;

import by.beer.entities.beeritem.manager.ManagerBeerItem;
import by.beer.entities.interfaces.Commandable;
import by.beer.entities.interfaces.Receiveriable;
import by.beer.menu.comands.Command;
import by.beer.menu.comands.Invoker;
import by.beer.menu.comands.ReceiverExitProgram;
import by.beer.menu.comands.ReceiverLoadBeerItemsFromXML;
import by.beer.menu.comands.ReceiverShowSortedBeerItemList;
import by.beer.resources.ResourceBundleManager;

/**
 * Class {@code SingleApplicationMenuFactory} represents a menu for user via
 * console.
 * 
 * @author Dmitry Zyablov
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

		// Application's greeting for user
		System.out.println(ResourceBundleManager.getProperty("app_greeting.message"));

		// Creates only one Scanner object for a whole menu
		Scanner inReader = new Scanner(System.in);

		// Creates an invoker for commands to execute
		Invoker commandInvoker = new Invoker();

		// Storages and manages a list of BeerItem objects
		ManagerBeerItem manager = new ManagerBeerItem();

		while (true) {
			try {

				System.out.println(ResourceBundleManager.getProperty("mainMenu.message"));

				String comandAction = inReader.nextLine();

				switch (comandAction) {
				case "1": {

					Receiveriable receiver = new ReceiverLoadBeerItemsFromXML(inReader, manager);
					this.setCommandToExecute(commandInvoker, receiver);
					commandInvoker.executeCommand();

					break;
				}

				case "2": {

					Receiveriable receiver = new ReceiverShowSortedBeerItemList(inReader, manager);
					this.setCommandToExecute(commandInvoker, receiver);
					commandInvoker.executeCommand();

					break;
				}

				case "3": {

					Receiveriable receiver = new ReceiverExitProgram(inReader, manager);
					this.setCommandToExecute(commandInvoker, receiver);
					commandInvoker.executeCommand();

					break;
				}

				default: {
					System.out.println(ResourceBundleManager.getProperty("menu.try"));
					// Ask user again
					continue;
				}
				}
			} catch (IllegalArgumentException e) {
				System.out.println(ResourceBundleManager.getProperty("menu.try"));
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
