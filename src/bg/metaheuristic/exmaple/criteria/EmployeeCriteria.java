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

	private static final int SEARCH_VALUE = 12942845;

	@Override
	public boolean process(final Resource resource) {

		final List<Integer> values = ((ListResource) resource).getValues();

		Collections.sort(values);

		boolean result = Collections.binarySearch(values, SEARCH_VALUE) > 0;

		Log.info("Result : " + result);
		return (result);
	}
}
