package bg.metaheuristic.exmaple.main;

import bg.metaheuristic.abc.environment.Environment;
import bg.metaheuristic.abc.util.Constants;
import bg.metaheuristic.abc.util.Utils;
import bg.metaheuristic.exmaple.generator.EnvironmentGenerator;
import bg.metaheuristic.log.Log;

/**
 * The main class of the application
 * 
 * @author Kiril Aleksandrov
 * 
 */
public class Generator {

	/**
	 * The generator entry point
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		if (args.length == 2) {
			final String filename = args[0];
			final int environmentSize = Integer.parseInt(args[1]);

			Log.info(Constants.LOG_RULE_THICK);
			Log.info("Generating environment with size " + environmentSize);

			final EnvironmentGenerator generator = new EnvironmentGenerator();
			generator.setEnvironmentSize(environmentSize);
			final Environment environment = generator.generate();

			Log.info("Environment generated!");

			Log.info("Saving to " + filename + "...");
			Utils.saveEnvironment(environment, filename);
			Log.info("Environment saved!");
		} else {
			Log.info("Please provide a single argument that is the filename of the file to be processed!");
		}
	}
}
