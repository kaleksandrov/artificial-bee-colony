package bg.metaheuristic.log;

import bg.metaheuristic.log.Logger.LogLevel;

/**
 * This class provides a public access to all logger methods. This way it is
 * used a single logger for the whole application that is accessed in a static
 * way.
 * 
 * @author Kiril Aleksandrov
 * 
 */
public class Log {
	private static Logger logger = new ConsoleLogger(LogLevel.INFO);

	/**
	 * Prevent outer instantiation
	 */
	private Log() {

	}

	public static void info(String message) {
		logger.info(message);
	}

	public static void debug(String message) {
		logger.debug(message);
	}

	public static void warn(String message) {
		logger.warn(message);
	}

	public static void error(String message) {
		logger.error(message);
	}

	public static void fatal(String message) {
		logger.fatal(message);
	}
}
