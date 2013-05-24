package bg.metaheuristic.abc.hive.bee;

import bg.metaheuristic.abc.criteria.Criteria;
import bg.metaheuristic.abc.environment.resource.Resource;
import bg.metaheuristic.abc.hive.Hive;
import bg.metaheuristic.log.Log;

/**
 * This is an implementation of the Bee class. It represents a worker that is
 * processing a resource
 * 
 * @author Kiril Aleksandrov
 * 
 */
public class EmployeeBee extends Bee {

	public EmployeeBee(final String name, final Criteria criteria,
			final Hive hive) {
		super(name, criteria, hive);
	}

	@Override
	public void run() {
		Log.debug(getName() + " started!");

		while (true) {
			Resource resource = null;
			try {
				resource = hive.getOnlookersQueue().dequeue();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (resource == null) {
				break;
			}

			if (criteria.process(resource)) {
				hive.putResult(resource);
				Log.debug(getName() + " consumed!");
			}

		}

		Log.debug(getName() + " finished!");
	}
}
