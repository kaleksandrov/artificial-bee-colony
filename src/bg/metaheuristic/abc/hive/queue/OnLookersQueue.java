package bg.metaheuristic.abc.hive.queue;

import bg.metaheuristic.abc.environment.resource.Resource;
import bg.metaheuristic.log.Log;

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
			Log.debug(Thread.currentThread().getName() + " notifies");
			queue.notify();
		}
	}

	@Override
	public Resource dequeue() throws InterruptedException {
		synchronized (queue) {
			if (queue.isEmpty()) {
				Log.debug(Thread.currentThread().getName()
						+ " starting to wait");
				queue.wait();
			}
			return queue.poll();
		}
	}
}
