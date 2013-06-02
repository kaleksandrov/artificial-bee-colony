package bg.metaheuristic.exmaple.generator;

import bg.metaheuristic.abc.environment.Environment;
import bg.metaheuristic.abc.environment.HashSetEnvironment;
import bg.metaheuristic.log.Log;

public class EnvironmentGenerator extends DummyGenerator<Environment> {

	private int environmentSize;

	@Override
	public Environment generate() {

		final Environment environment = new HashSetEnvironment();

		final ResourceGenerator resourceGenerator = new ResourceGenerator();

		Log.info("Size : " + environmentSize);

		for (int i = 0; i < environmentSize; i++) {
			Log.info("Index : " + i);

			environment.addResource(resourceGenerator.generate());
		}

		return environment;
	}

	/* Getters & Setters */

	public int getEnvironmentSize() {
		return environmentSize;
	}

	public void setEnvironmentSize(int environmentSize) {
		this.environmentSize = environmentSize;
	}
}
