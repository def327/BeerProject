package by.beer.menu.comands;

import by.beer.entities.interfaces.Commandable;

/**
 * Class {@code Invoker} holds a {@code Commandable} object to execute.
 * 
 * @author Dmitry Zyablov
 * @see Commandable
 *
 */
public class Invoker {

	/**
	 * Command to execute.
	 */
	private Commandable command;

	/**
	 * Executes a storage command.
	 */
	public void executeCommand() {
		this.command.execute();
	}

	/**
	 * Constructs a default <code>Invoker</code>.
	 */
	public Invoker() {
	}

	public void setCommand(Commandable command) {
		this.command = command;
	};

}
