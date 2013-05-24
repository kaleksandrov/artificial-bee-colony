package bg.metaheuristic.abc.hive;

import java.util.HashSet;
import java.util.Set;

import bg.metaheuristic.abc.criteria.Criteria;
import bg.metaheuristic.abc.environment.Environment;
import bg.metaheuristic.abc.hive.bee.Bee;
import bg.metaheuristic.abc.hive.bee.EmployeeBee;
import bg.metaheuristic.abc.hive.bee.ScoutBee;
import bg.metaheuristic.abc.hive.queue.OnLookersQueue;
import bg.metaheuristic.abc.hive.queue.ResourceQueue;

/**
 * Class representing the bee hive.
 * 
 * @author Kiril Aleksandrov
 * 
 */
public class Hive {

	private Set<Bee> employees;
	private Set<Bee> scouts;
	private ResourceQueue onlookersQueue;
	private Environment environment;
	private Integer workingScoutsCount;

	public Hive(final int employeesCount, final int scoutsCount,
			final Environment environment, final Criteria scoutCriteria,
			final Criteria employeeCriteria) {

		this.onlookersQueue = new OnLookersQueue();
		this.environment = environment;
		this.workingScoutsCount = scoutsCount;

		initEmployeeBees(employeesCount, employeeCriteria);
		initScouts(scoutsCount, scoutCriteria);
	}

	/**
	 * Fires up the show! The scout bees are send to search resources, employee
	 * bees are working on the currently found resource, everything works like a
	 * charm :))
	 */
	public void start() {
		sendScoutsToInvestigate();
		wakeUpEmployees();
		waitToFinish();
	}

	/**
	 * Checks if the current environment is exhausted (is running out of
	 * resources)
	 * 
	 * @return
	 */
	public boolean isEnvironmentExhausted() {
		synchronized (workingScoutsCount) {
			return (workingScoutsCount == 0);
		}
	}

	/**
	 * Decrease the number of active scouts. When there is no resource to be
	 * checked the scouts are going inactive
	 */
	public void decreaseWorkingScoutsCount() {
		synchronized (workingScoutsCount) {
			workingScoutsCount--;
		}
	}

	/**
	 * Creates the employee bees
	 * 
	 * @param count
	 * @param criteria
	 */
	private void initEmployeeBees(final int count, final Criteria criteria) {
		employees = new HashSet<Bee>(count);
		for (int i = 0; i < count; i++) {
			employees.add(new EmployeeBee(onlookersQueue, criteria, this));
		}
	}

	/**
	 * Creates the scout bees
	 * 
	 * @param count
	 * @param criteria
	 */
	private void initScouts(final int count, final Criteria criteria) {
		scouts = new HashSet<Bee>(count);
		for (int i = 0; i < count; i++) {
			scouts.add(new ScoutBee(environment, onlookersQueue, criteria, this));
		}
	}

	/**
	 * Stars all scouts and send them to investigate and filter resources
	 */
	private void sendScoutsToInvestigate() {
		for (Bee bee : scouts) {
			bee.start();
		}
	}

	/**
	 * Wakse up all the employee bees that are waiting for a propriate resource
	 * to be processed
	 */
	private void wakeUpEmployees() {
		for (Bee bee : employees) {
			bee.start();
		}
	}

	/**
	 * Tell the current thread to wait all the bees to finish their work
	 */
	private void waitToFinish() {

		try {

			for (Bee scout : scouts) {
				scout.join();
			}

			for (Bee employee : employees) {
				employee.join();
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* Getters & Setters */

	public ResourceQueue getOnlookersQueue() {
		return onlookersQueue;
	}
}
