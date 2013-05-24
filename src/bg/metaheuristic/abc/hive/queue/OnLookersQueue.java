package bg.metaheuristic.abc.hive.queue;

import bg.metaheuristic.abc.environment.resource.Resource;

/**
 * Queue representing the onlookers bees
 * 
 * @author Kiril Aleksandrov
 * 
 */
public class OnLookersQueue extends ResourceQueue {

	@Override
	public void enqueue(final Resource element) {
		synchronized (queue) {
			queue.offer(element);
			queue.notify();
		}
	}

	@Override
	public Resource dequeue() throws InterruptedException {
		synchronized (queue) {
			while (queue.isEmpty()) {
				queue.wait();
			}
			return queue.poll();
		}
	}
}
