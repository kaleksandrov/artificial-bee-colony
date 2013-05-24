package bg.metaheuristic.abc.hive.bee;

import bg.metaheuristic.abc.criteria.Criteria;
import bg.metaheuristic.abc.environment.Environment;
import bg.metaheuristic.abc.environment.resource.Resource;
import bg.metaheuristic.abc.hive.Hive;
import bg.metaheuristic.abc.hive.queue.ResourceQueue;
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

	public ScoutBee(final Environment environment,
			final ResourceQueue onlookersQueue, final Criteria criteria,
			final Hive hive) {
		this.environment = environment;
		super.criteria = criteria;
		super.hive = hive;
	}

	@Override
	public void run() {

		Log.debug("SCOUT : " + Thread.currentThread().getName() + " Started");

		while (true) {
			Resource resource = null;

			Log.debug("SCOUT : " + Thread.currentThread().getName()
					+ " Get resource from env...");
			resource = environment.getResource();

			if (resource != null) {

				if (criteria.process(resource)) {
					Log.debug("SCOUT : " + Thread.currentThread().getName()
							+ " Enque task " + resource.toString());
					hive.getOnlookersQueue().enqueue(resource);
				}
			} else {
				hive.decreaseWorkingScoutsCount();
				break;
			}
		}

		Log.debug("SCOUT : " + Thread.currentThread().getName() + " finished");
	};
}
