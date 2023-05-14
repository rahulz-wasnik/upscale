package use.wait.notify;
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
			if (semaphore.isNoMoreFilesLeftToProcess()) {
				semaphore.waitToStartProcessing();
				
			} 
			
			File file = semaphore.fetchFile();
			if (file != null) {
				System.out.println("Reading from file - " + file.getName() + " - " + Thread.currentThread().getName());
				semaphore.notifyToStartMovingFilesForProcessing();					
			}
			
		}
	}
}
