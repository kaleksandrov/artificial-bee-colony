package bg.metaheuristic.abc.hive.bee;

import bg.metaheuristic.abc.criteria.Criteria;
import bg.metaheuristic.abc.hive.Hive;

/**
 * This is an abstract class that represents a basic <b>Bee</b>
 * 
 * @author Kiril Aleksandrov
 * 
 */
public abstract class Bee extends Thread {

	protected Criteria criteria;

	protected Hive hive;

}
