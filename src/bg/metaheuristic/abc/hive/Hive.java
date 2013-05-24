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

	public void start() {
		sendScoutsToInvestigate();
		wakeUpEmployees();
		waitToFinish();
	}

	public boolean isEnvironmentExhausted() {
		synchronized (workingScoutsCount) {
			return (workingScoutsCount == 0);
		}
	}

	public void decreaseWorkingScoutsCount() {
		synchronized (workingScoutsCount) {
			workingScoutsCount--;
		}
	}

	private void initEmployeeBees(final int count, final Criteria criteria) {
		employees = new HashSet<Bee>(count);
		for (int i = 0; i < count; i++) {
			employees.add(new EmployeeBee(onlookersQueue, criteria, this));
		}
	}

	private void initScouts(final int count, final Criteria criteria) {
		scouts = new HashSet<Bee>(count);
		for (int i = 0; i < count; i++) {
			scouts.add(new ScoutBee(environment, onlookersQueue, criteria, this));
		}
	}

	private void sendScoutsToInvestigate() {
		for (Bee bee : scouts) {
			bee.start();
		}
	}

	private void wakeUpEmployees() {
		for (Bee bee : employees) {
			bee.start();
		}
	}

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
