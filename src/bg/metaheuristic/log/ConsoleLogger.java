package bg.metaheuristic.log;

/**
 * Implementation of the Logger class. Logs everything to the standard output
 * @author Kiril Aleksandrov
 *
 */
public class ConsoleLogger extends Logger {

	public ConsoleLogger(final LogLevel logLevel) {
		super(logLevel);
	}

	/**
	 * Logs the message in the standard output
	 */
	@Override
	protected void logMethod(final String message, final LogLevel prefix) {
		System.out.println(prefix + message);
	}
}
