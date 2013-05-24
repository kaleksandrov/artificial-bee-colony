package bg.metaheuristic.abc.hive.bee;

import bg.metaheuristic.abc.criteria.Criteria;
import bg.metaheuristic.abc.environment.Environment;
import bg.metaheuristic.abc.environment.resource.Resource;
import bg.metaheuristic.abc.hive.Hive;
import bg.metaheuristic.log.Log;

/**
 * This is an implementation of the Bee class. It represents a bee that searches
 * for a good resource
 * 
 * @author Kiril Aleksandrov
 * 
 */
public class ScoutBee extends Bee {

	private Environment environment;

	public ScoutBee(final String name, final Environment environment,
			final Criteria criteria, final Hive hive) {
		super(name, criteria, hive);
		this.environment = environment;
	}

	@Override
	public void run() {

		Log.debug(getName() + " started");

		while (true) {
			Resource resource = null;

			resource = environment.getResource();

			if (resource != null) {

				if (criteria.process(resource)) {
					Log.debug(getName() + " enque");
					hive.getOnlookersQueue().enqueue(resource);
				}
			} else {
				break;
			}
		}

		Log.debug(getName() + " finished!");
	};
}
