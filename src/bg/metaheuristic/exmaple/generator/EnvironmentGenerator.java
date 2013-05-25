package bg.metaheuristic.exmaple.generator;

import bg.metaheuristic.abc.environment.Environment;
import bg.metaheuristic.abc.environment.HashSetEnvironment;
import bg.metaheuristic.abc.environment.resource.Resource;
import bg.metaheuristic.abc.util.Constants;
import bg.metaheuristic.log.Log;

public class EnvironmentGenerator extends Generator<Environment> {

	private int generateEnvironmentSize() {
		return randomInt(Constants.ENVIRONMENT_MIN_SIZE,
				Constants.ENVIRONMENT_MAX_SIZE);
	}

	@Override
	public Environment generate() {

		Log.info(Constants.LOG_RULE_THICK);
		Log.info("Generating environment");

		final Environment environment = new HashSetEnvironment();
		final int environmentSize = generateEnvironmentSize();

		Log.info("Size : " + environmentSize);

		final Generator<Resource> resourceGenerator = new ResourceGenerator();

		for (int i = 0; i < environmentSize; i++) {
			Log.info("Index : " + i);
			environment.addResource(resourceGenerator.generate());
		}

		Log.info("Environment generated!");

		return environment;
	}
}