package bg.metaheuristic.exmaple.main;

import bg.metaheuristic.abc.criteria.Criteria;
import bg.metaheuristic.abc.environment.Environment;
import bg.metaheuristic.abc.environment.HashSetEnvironment;
import bg.metaheuristic.abc.environment.resource.FoodResource;
import bg.metaheuristic.abc.environment.resource.Resource;
import bg.metaheuristic.abc.environment.resource.WaterResource;
import bg.metaheuristic.abc.environment.resource.WoodResource;
import bg.metaheuristic.abc.hive.Hive;

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

		final Environment environment = new HashSetEnvironment() {
			{

				addResource(new WaterResource());
				addResource(new FoodResource());
				addResource(new WoodResource());
				addResource(new FoodResource());
				addResource(new FoodResource());
				addResource(new WaterResource());
				addResource(new WoodResource());
				addResource(new FoodResource());
				addResource(new FoodResource());
				addResource(new FoodResource());
				addResource(new WoodResource());
				addResource(new WaterResource());
				addResource(new WaterResource());
			}
		};

		final Criteria employeeCriteria = new Criteria() {

			@Override
			public boolean process(final Resource resource) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				return true;
			}
		};

		final Criteria scoutCriteria = new Criteria() {

			@Override
			public boolean process(Resource resource) {
				return (resource instanceof FoodResource);
			}
		};

		final Hive hive = new Hive(10, 10, environment, scoutCriteria,
				employeeCriteria);
		hive.start();
	}
}
