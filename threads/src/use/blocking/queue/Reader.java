package use.blocking.queue;

import java.io.File;

public class Reader implements Runnable {

	private Semaphore semaphore;
	private boolean killReader;

	public Reader(Semaphore semaphore) {
		this.semaphore = semaphore;
		this.killReader = false;
	}

	@Override
	public void run() {

		while (!killReader) {
			try {
				File file = semaphore.getFiles().take();
				if (file != null) {
					System.out.println(
							"Reading from file - " + file.getName() + " - " + Thread.currentThread().getName());
				}
			} catch (InterruptedException e) {
				break;
			}

		}
	}
}
