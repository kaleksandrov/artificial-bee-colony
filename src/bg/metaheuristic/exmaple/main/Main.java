package bg.metaheuristic.exmaple.main;

import bg.metaheuristic.abc.criteria.Criteria;
import bg.metaheuristic.abc.environment.Environment;
import bg.metaheuristic.abc.hive.Hive;
import bg.metaheuristic.exmaple.criteria.EmployeeCriteria;
import bg.metaheuristic.exmaple.criteria.ScoutCriteria;
import bg.metaheuristic.exmaple.generator.EnvironmentGenerator;
import bg.metaheuristic.exmaple.generator.Generator;

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

		final Generator<Environment> generator = new EnvironmentGenerator();
		final Environment environment = generator.generate();
		final Criteria scoutCriteria = new ScoutCriteria();
		final Criteria employeeCriteria = new EmployeeCriteria();

		final Hive hive = new Hive(10, 10, environment, scoutCriteria,
				employeeCriteria);
		hive.start();
	}
}
