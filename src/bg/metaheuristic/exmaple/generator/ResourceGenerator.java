package bg.metaheuristic.exmaple.generator;

import java.util.ArrayList;
import java.util.List;

import bg.metaheuristic.abc.environment.resource.Resource;
import bg.metaheuristic.abc.util.Constants;
import bg.metaheuristic.exmaple.resource.ListResource;
import bg.metaheuristic.log.Log;

public class ResourceGenerator extends Generator<Resource> {

	private int generateListSize() {
		return randomInt(Constants.LIST_MIN_SIZE, Constants.LIST_MAX_SIZE);
	}

	@Override
	public Resource generate() {

//		Log.info(Constants.LOG_RULE_THIN);
//		Log.info("Generating resource");

		final int listSize = generateListSize();

		Log.info("Size : " + listSize);

		final List<Integer> list = new ArrayList<Integer>(listSize);
		final Resource resource = new ListResource(list);

		for (int i = 0; i < listSize; i++) {
			list.add(randomInt(0, 10));
		}

//		Log.info("Done!");

		return resource;
	}
}
