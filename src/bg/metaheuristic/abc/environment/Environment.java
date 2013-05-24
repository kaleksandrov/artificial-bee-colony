package bg.metaheuristic.abc.environment;

import bg.metaheuristic.abc.environment.resource.Resource;

/**
 * Abstract class representing the environment where all the resources are
 * located. Here is stored the data that the bees are going to process
 * 
 * @author Kiril Aleksandrov
 * 
 */
public abstract class Environment {

	/**
	 * Return a single resource from the environment
	 * 
	 * @return
	 */
	public abstract Resource getResource();
}
