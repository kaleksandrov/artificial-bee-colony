package bg.metaheuristic.exmaple.resource;

import java.util.List;

import bg.metaheuristic.abc.environment.resource.Resource;

/**
 * Implementation of the resource class. Holds a bunch of values in a list
 * collection.
 * 
 * @author Kiril Aleksandrov
 * 
 */
public class ListResource extends Resource {

	private List<Integer> values;

	public ListResource(final List<Integer> values) {
		this.values = values;
	}

	public List<Integer> getValues() {
		return values;
	}

	public void setValues(List<Integer> values) {
		this.values = values;
	}
}
