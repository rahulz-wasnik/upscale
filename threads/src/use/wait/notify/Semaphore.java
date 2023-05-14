package use.wait.notify;
import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class Semaphore {

	private Object FULL_QUEUE = new Object();
	private Object START_PROCESSING = new Object();
	private Queue<File> files = new LinkedList<File>();
	private int MAX_CAPACITY = 1;
	
	public void notifyToStartMovingFilesForProcessing() {
		synchronized (FULL_QUEUE) {
			FULL_QUEUE.notifyAll();
		}
	}
	
	public void waitOnFullQueue() {
		synchronized (FULL_QUEUE) {
			try {
				FULL_QUEUE.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void waitToStartProcessing() {
		synchronized (START_PROCESSING) {
			try {
				START_PROCESSING.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void notifyToStartProcessing() {
		synchronized (START_PROCESSING) {
			START_PROCESSING.notifyAll();
		}
	}
	
	
	public void addFileToProcess(File file) {
		synchronized (files) {
			files.add(file);
		}
	}
	
	public File fetchFile() {
		synchronized (files) {
			return files.poll();
		}
	}
	
	public boolean isProcessingQueueAtMaxCapacity() {
		return files.size() == MAX_CAPACITY;
	}
	
	public boolean isNoMoreFilesLeftToProcess() {
		return files.isEmpty();
	}
}
