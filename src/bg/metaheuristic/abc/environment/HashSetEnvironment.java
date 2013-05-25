package bg.metaheuristic.abc.environment;

import bg.metaheuristic.abc.collection.set.SynchronizedHashSetProvider;
import bg.metaheuristic.abc.environment.resource.Resource;

/**
 * Simple implementation of the Environment that uses HashSet collection for
 * storing its resources
 * 
 * @author Kiril Aleksandrov
 */
public class HashSetEnvironment extends Environment {

	private SynchronizedHashSetProvider resources;

	public HashSetEnvironment() {
		resources = new SynchronizedHashSetProvider();
	}

	@Override
	public Resource getResource() {
		Resource resource = null;

		synchronized (resources) {
			if (!resources.isEmpty()) {
				resource = resources.get();
			}
		}

		return resource;
	}

	/**
	 * Adds the given resource to the environment
	 * 
	 * @param resource
	 */
	@Override
	public void addResource(final Resource resource) {
		if (resource != null) {
			resources.add(resource);
		}
	}
}
