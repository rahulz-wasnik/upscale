package use.blocking.queue;
import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Semaphore {

	private BlockingQueue<File> files = new LinkedBlockingDeque<>(3);
	
	public BlockingQueue<File> getFiles() {
		return files;
	}
}
