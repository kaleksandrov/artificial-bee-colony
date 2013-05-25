package bg.metaheuristic.exmaple.resource;

import java.util.List;

import bg.metaheuristic.abc.environment.resource.Resource;

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
