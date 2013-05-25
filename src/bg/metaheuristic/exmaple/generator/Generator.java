package bg.metaheuristic.exmaple.generator;

import java.util.Random;

public abstract class Generator<T> {

	protected int randomInt(final int min, final int max) {
		final Random randomGenerator = new Random();
		final int randomNumber = randomGenerator.nextInt(max - min);

		return (min + randomNumber);
	}

	protected int randomInt() {
		final Random randomGenerator = new Random();
		return randomGenerator.nextInt();
	}

	public abstract T generate();

	public abstract T generate(final int size);

}
