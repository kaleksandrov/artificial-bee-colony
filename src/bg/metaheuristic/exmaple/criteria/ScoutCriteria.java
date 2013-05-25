package bg.metaheuristic.exmaple.criteria;

import bg.metaheuristic.abc.criteria.Criteria;
import bg.metaheuristic.abc.environment.resource.Resource;
import bg.metaheuristic.abc.util.Constants;
import bg.metaheuristic.exmaple.resource.ListResource;

/**
 * Implementation of the Criteria class. Checks if the given resource size is
 * larger than the average size.
 * 
 * @author Kiril Aleksandrov
 * 
 */
public class ScoutCriteria extends Criteria {

	@Override
	public boolean process(Resource resource) {
		return ((ListResource) resource).getValues().size() > Constants.LIST_AVERAGE_SIZE;
	}

}
