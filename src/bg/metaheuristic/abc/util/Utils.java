package bg.metaheuristic.abc.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import bg.metaheuristic.abc.environment.Environment;
import bg.metaheuristic.abc.environment.HashSetEnvironment;
import bg.metaheuristic.abc.environment.resource.Resource;
import bg.metaheuristic.exmaple.resource.ListResource;

/**
 * Class holding static utility methods
 * 
 * @author Kiril Aleksandrov
 * 
 */
public class Utils {

	/**
	 * Private constructor to prevent outer instantiation
	 */
	private Utils() {

	}

	/**
	 * Saves the environment to a file
	 * 
	 * @param environment
	 * @param filename
	 */
	public static void saveEnvironment(final Environment environment,
			final String filename) {
		try {
			PrintWriter writer = new PrintWriter(new File(filename));

			ListResource resource = (ListResource) environment.getResource();
			while (resource != null) {
				for (int value : resource.getValues()) {
					writer.print(value);
					writer.print(Constants.FIELD_SEPARATOR);
				}

				writer.println();

				resource = (ListResource) environment.getResource();
			}
			writer.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Loads the environment from a file
	 * 
	 * @param filename
	 * @return
	 */
	public static Environment loadEnvironment(String filename) {

		final Environment environment = new HashSetEnvironment();

		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] elements = line.split(Constants.FIELD_SEPARATOR);
				List<Integer> values = new ArrayList<Integer>();
				for (String element : elements) {
					values.add(Integer.parseInt(element));
				}

				final Resource resource = new ListResource(values);
				environment.addResource(resource);
			}
			reader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return environment;
	}

}
