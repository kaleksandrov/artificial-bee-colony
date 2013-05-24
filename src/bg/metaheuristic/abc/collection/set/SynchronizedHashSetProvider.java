package bg.metaheuristic.abc.collection.set;

import java.util.HashSet;
import java.util.Iterator;

import bg.metaheuristic.abc.environment.resource.Resource;

/**
 * Implementation of HashSet that provides the functionality to return a random
 * element from the Set in synchronous way.
 * 
 * @author Kiril Aleksandrov
 */
public class SynchronizedHashSetProvider extends HashSet<Resource> implements
		ElementProvider<Resource> {

	private static final long serialVersionUID = 1L;

	/**
	 * Implementation of HashSet that provides the functionality to return a
	 * random element from the Set in synchronous way.
	 */
	public SynchronizedHashSetProvider() {
	}

	/**
	 * Implementation of HashSet that provides the functionality to return a
	 * random element from the Set in synchronous way.
	 * 
	 * @param initialCapacity
	 *            The initial capacity of the set
	 */
	public SynchronizedHashSetProvider(final int initialCapacity) {
		super(initialCapacity);
	}

	/**
	 * Returns a random element from the Set. The method is synchronized on the
	 * current instance.
	 */
	@Override
	public Resource get() {
		Resource element = null;

		synchronized (this) {
			final Iterator<Resource> iter = iterator();
			element = iter.next();
			iter.remove();
		}

		return element;
	}

}
