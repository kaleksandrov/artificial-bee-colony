package bg.metaheuristic.abc.hive.bee;

import bg.metaheuristic.abc.criteria.Criteria;
import bg.metaheuristic.abc.environment.resource.Resource;
import bg.metaheuristic.abc.hive.Hive;
import bg.metaheuristic.abc.hive.queue.ResourceQueue;
import bg.metaheuristic.log.Log;

/**
 * This is an implementation of the Bee class. It represents a worker that is
 * processing a resource
 * 
 * @author Kiril Aleksandrov
 * 
 */
public class EmployeeBee extends Bee {

	public EmployeeBee(final ResourceQueue onlookersQueue,
			final Criteria criteria, final Hive hive) {
		super.criteria = criteria;
		super.hive = hive;
	}

	@Override
	public void run() {
		Log.debug("EMPLOYEE : " + Thread.currentThread().getName() + " Started");

		while (hive.isEnvironmentExhausted()) {
			Resource resource = null;
			try {
				resource = hive.getOnlookersQueue().dequeue();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (resource == null) {
				break;
			}

			Log.debug("EMPLOYEE : " + Thread.currentThread().getName()
					+ " consume....");

			if (criteria.process(resource)) {
				Log.debug("EMPLOYEE : " + Thread.currentThread().getName()
						+ " consumed!");
			}

		}

		Log.debug("EMPLOYEE : " + Thread.currentThread().getName()
				+ " Finished!");
	}
}
