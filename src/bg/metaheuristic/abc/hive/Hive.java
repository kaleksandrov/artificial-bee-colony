package bg.metaheuristic.abc.hive;

import java.util.HashSet;
import java.util.Set;

import bg.metaheuristic.abc.criteria.Criteria;
import bg.metaheuristic.abc.environment.Environment;
import bg.metaheuristic.abc.environment.resource.Resource;
import bg.metaheuristic.abc.hive.bee.Bee;
import bg.metaheuristic.abc.hive.bee.EmployeeBee;
import bg.metaheuristic.abc.hive.bee.ScoutBee;
import bg.metaheuristic.abc.hive.queue.OnLookersQueue;
import bg.metaheuristic.abc.util.Constants;
import bg.metaheuristic.log.Log;

/**
 * Class representing the bee hive.
 * 
 * @author Kiril Aleksandrov
 * 
 */
public class Hive {

	private Set<Bee> employees;
	private Set<Bee> scouts;
	private OnLookersQueue onlookersQueue;
	private Environment environment;
	private Set<Resource> result;

	public Hive(final int employeesCount, final int scoutsCount,
			final Environment environment, final Criteria scoutCriteria,
			final Criteria employeeCriteria) {

		this.onlookersQueue = new OnLookersQueue();
		this.result = new HashSet<Resource>();
		this.environment = environment;

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

	public void putResult(final Resource resource) {
		synchronized (result) {
			result.add(resource);
		}
	}

	/**
	 * Creates the employee bees
	 * 
	 * @param count
	 * @param criteria
	 */
	private void initEmployeeBees(final int count, final Criteria criteria) {
		Log.info(Constants.LOG_RULE_THICK);
		Log.info("Init scout bees...");

		employees = new HashSet<Bee>(count);
		for (int i = 0; i < count; i++) {
			employees.add(new EmployeeBee("Employee_" + i, criteria, this));
		}

		Log.info("Done!");
	}

	/**
	 * Creates the scout bees
	 * 
	 * @param count
	 * @param criteria
	 */
	private void initScouts(final int count, final Criteria criteria) {
		Log.info(Constants.LOG_RULE_THICK);
		Log.info("Init employee bees...");

		scouts = new HashSet<Bee>(count);
		for (int i = 0; i < count; i++) {
			scouts.add(new ScoutBee("Scout_" + i, environment, criteria, this));
		}

		Log.info("Done!");
	}

	/**
	 * Stars all scouts and send them to investigate and filter resources
	 */
	private void sendScoutsToInvestigate() {
		Log.info(Constants.LOG_RULE_THICK);
		Log.info("Send scout bees...");

		for (Bee bee : scouts) {
			bee.start();
		}

		Log.info("Done!");
	}

	/**
	 * Wakse up all the employee bees that are waiting for a propriate resource
	 * to be processed
	 */
	private void wakeUpEmployees() {
		Log.info(Constants.LOG_RULE_THICK);
		Log.info("Wake up employee bees...");

		for (Bee bee : employees) {
			bee.start();
		}

		Log.info("Done!");
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

	public OnLookersQueue getOnlookersQueue() {
		return onlookersQueue;
	}
}
