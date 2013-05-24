package bg.metaheuristic.log;

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
