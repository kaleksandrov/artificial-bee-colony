package bg.metaheuristic.exmaple.criteria;

import java.util.Collections;
import java.util.List;

import bg.metaheuristic.abc.criteria.Criteria;
import bg.metaheuristic.abc.environment.resource.Resource;
import bg.metaheuristic.exmaple.resource.ListResource;
import bg.metaheuristic.log.Log;

/**
 * Implementation of the Criteria class. Searches in the resource the number
 * <b>7</b>.
 * 
 * @author Kiril Aleksandrov
 * 
 */
public class EmployeeCriteria extends Criteria {

	@Override
	public boolean process(final Resource resource) {

		final List<Integer> values = ((ListResource) resource).getValues();

		Collections.sort(values);

		final int result = Collections.binarySearch(values, 7);
		Log.info("Result : " + result);
		return (result > 0);
	}
}
