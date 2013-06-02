package bg.metaheuristic.exmaple.generator;

import java.util.ArrayList;
import java.util.List;

import bg.metaheuristic.abc.environment.resource.Resource;
import bg.metaheuristic.abc.util.Constants;
import bg.metaheuristic.exmaple.resource.ListResource;
import bg.metaheuristic.log.Log;

/**
 * Generates a resource object filled up with dummy values
 * 
 * @author Kiril Aleksandrov
 * 
 */
public class ResourceGenerator extends DummyGenerator<Resource> {

	private int generateListSize() {
		return randomInt(Constants.LIST_MIN_SIZE, Constants.LIST_MAX_SIZE);
	}

	@Override
	public Resource generate() {

		final int size = generateListSize();
		return generate(size);
	}

	// @Override
	public Resource generate(final int size) {

		Log.info("Size : " + size);

		final List<Integer> list = new ArrayList<Integer>(size);
		final Resource resource = new ListResource(list);

		for (int i = 0; i < size; i++) {
			list.add(randomInt(0, 100000000));
		}

		return resource;
	}
}
