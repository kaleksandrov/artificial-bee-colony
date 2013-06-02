package bg.metaheuristic.exmaple.main;

import bg.metaheuristic.abc.criteria.Criteria;
import bg.metaheuristic.abc.environment.Environment;
import bg.metaheuristic.abc.hive.Hive;
import bg.metaheuristic.abc.util.Utils;
import bg.metaheuristic.exmaple.criteria.EmployeeCriteria;
import bg.metaheuristic.exmaple.criteria.ScoutCriteria;
import bg.metaheuristic.log.Log;

/**
 * The main class of the application
 * 
 * @author Kiril Aleksandrov
 * 
 */
public class Main {

	/**
	 * The entry point of the application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		if (args.length == 3) {
			final int scoutCount = Integer.parseInt(args[0]);
			final int employeeCount = Integer.parseInt(args[1]);
			final String filename = args[2];

			final Environment environment = Utils.loadEnvironment(filename);
			final Criteria scoutCriteria = new ScoutCriteria();
			final Criteria employeeCriteria = new EmployeeCriteria();
			
			final Hive hive = new Hive(employeeCount, scoutCount, environment,
					scoutCriteria, employeeCriteria);
			hive.start();
		} else {
			Log.info("Please provide three arguments : scouts couts, employees count, filename!");
		}
	}
}
