package bg.metaheuristic.abc.hive.queue;

import java.util.LinkedList;
import java.util.Queue;

import bg.metaheuristic.abc.environment.resource.Resource;

/**
 * Class representing a Queue of resources. Provides two basic methods for
 * adding and retrieveing values to and from the queue
 * 
 * @author Kiril Aleksandrov
 * 
 */
public abstract class ResourceQueue {

	protected Queue<Resource> queue;

	public ResourceQueue() {
		this.queue = new LinkedList<Resource>();
	}

	/**
	 * Adds the given resource to the queue
	 * 
	 * @param resource
	 */
	public void enqueue(final Resource resource) {
		synchronized (this.queue) {
			this.queue.offer(resource);
		}
	}

	/**
	 * Gets the oldest element from the queue
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public Resource dequeue() throws InterruptedException {
		synchronized (this.queue) {
			return this.queue.poll();
		}
	}
}
