package bg.metaheuristic.abc.criteria;

import bg.metaheuristic.abc.environment.resource.Resource;

public abstract class Criteria {

	public abstract boolean process(final Resource resource);
}
