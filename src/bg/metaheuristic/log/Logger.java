package bg.metaheuristic.log;

/**
 * Abstract logger class. Holds a couple of methods for logging in a different
 * logging level. Should be extended and the child class should implement the
 * <b>logMethod</b> method. This method is called for logging the messages.
 * 
 * @author Kiril Aleksandrov
 * 
 */
public abstract class Logger {
	/**
	 * Represent the level of logging.
	 * 
	 * @author Kiril Aleksandrov
	 * 
	 */
	protected static enum LogLevel {
		INFO("I : ", 5), DEBUG("D : ", 4), WARN("W : ", 3), ERROR("E : ", 2), FATAL(
				"F : ", 1);

		private String prefix;

		private int weight;

		private LogLevel(final String prefix, final int weight) {
			this.prefix = prefix;
			this.weight = weight;
		}

		/**
		 * Checks if the current log level allows logging messages with the
		 * given log level.
		 * 
		 * @param logLevel
		 *            LogLevel to be checked
		 * @return <b>true</b> or <b>false</b>
		 */
		public boolean allows(LogLevel logLevel) {
			return (this.weight >= logLevel.weight);
		}

		@Override
		public String toString() {
			return prefix;
		}
	}

	public Logger(final LogLevel logLevel) {
		this.logLevel = logLevel;
	}

	protected LogLevel logLevel;

	public void info(final String message) {
		log(message, LogLevel.INFO);
	}

	public void debug(final String message) {
		log(message, LogLevel.DEBUG);
	}

	public void warn(final String message) {
		log(message, LogLevel.WARN);
	}

	public void error(final String message) {
		log(message, LogLevel.ERROR);
	}

	public void fatal(final String message) {
		log(message, LogLevel.FATAL);
	}

	private void log(final String message, final LogLevel prefix) {
		if (logLevel.allows(prefix)) {
			logMethod(message, prefix);
		}
	}

	/**
	 * This method is called when a message is logged. It should be overridden
	 * in the child class. If you want to log the messages on a remote server or
	 * in the standard output or a file - this is the place where you should do
	 * this.
	 * 
	 * @param message
	 * @param prefix
	 */
	protected abstract void logMethod(final String message,
			final LogLevel prefix);

	/* Getters && Setters */

	public LogLevel getLogLevel() {
		return logLevel;
	}
}
