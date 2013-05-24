package bg.metaheuristic.abc.criteria;

import bg.metaheuristic.abc.environment.resource.Resource;

/**
 * Abstract class that is used to pass an acceptance criteria to the bees
 * 
 * @author Kiril Aleksandrov
 * 
 */
public abstract class Criteria {

	/**
	 * Process the given data so the bee can decide what to do
	 * 
	 * @param resource
	 * @return
	 */
	public abstract boolean process(final Resource resource);
}
