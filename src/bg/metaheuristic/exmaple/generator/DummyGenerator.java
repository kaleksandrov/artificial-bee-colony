package bg.metaheuristic.exmaple.generator;

import java.util.Random;

/**
 * Generates a dummy values
 * 
 * @author Kiril Aleksandrov
 * 
 * @param <T>
 */
public abstract class DummyGenerator<T> {

	/**
	 * Generates a ranom int number between the given bounds
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
	protected int randomInt(final int min, final int max) {
		final Random randomGenerator = new Random();
		final int randomNumber = randomGenerator.nextInt(max - min);

		return (min + randomNumber);
	}

	/**
	 * Generates a random int number
	 * 
	 * @return
	 */
	protected int randomInt() {
		final Random randomGenerator = new Random();
		return randomGenerator.nextInt();
	}

	/**
	 * Generates a dummy object with random size
	 * 
	 * @return
	 */
	public abstract T generate();

	/**
	 * Generates a dummy object using the given size
	 * 
	 * @param size
	 * @return
	 */
	public abstract T generate(final int size);

}
