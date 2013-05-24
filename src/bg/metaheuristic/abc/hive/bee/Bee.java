package bg.metaheuristic.abc.hive.bee;

import bg.metaheuristic.abc.criteria.Criteria;
import bg.metaheuristic.abc.hive.Hive;
import bg.metaheuristic.log.Log;

/**
 * This is an abstract class that represents a basic <b>Bee</b>
 * 
 * @author Kiril Aleksandrov
 * 
 */
public abstract class Bee extends Thread {

	protected Criteria criteria;

	protected Hive hive;

	public Bee(final String name, final Criteria criteria, final Hive hive) {
		super(name);

		this.criteria = criteria;
		this.hive = hive;

		Log.info("Bee " + name + " created!");
	}

}
