package by.beer.menu.comands;

import by.beer.entities.interfaces.Commandable;
import by.beer.entities.interfaces.Receiveriable;

/**
 * CLass {@code Command} provides method to execute commands from user.
 *
 * 
 * @author Dmitry Zyablov
 * 
 * @see Commandable
 *
 */
public class Command implements Commandable {

	/**
	 * A command receiver to execute.
	 */
	private Receiveriable commandReceiver;

	/**
	 * Executes a command.
	 */
	@Override
	public void execute() {
		commandReceiver.action();
	}

	/**
	 * Constructs a <code>Command</code> object based on a command.
	 * 
	 * @param commandReceiver
	 *            - a command receiver to execute
	 */
	public Command(Receiveriable commandReceiver) {
		this.commandReceiver = commandReceiver;
	}

}
