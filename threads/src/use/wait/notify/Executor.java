package use.wait.notify;

public class Executor {

	public static void main(String[] args) {
		
		Semaphore semaphore = new Semaphore();
		
		Mover mover = new Mover(semaphore);
		Thread moverThread = new Thread(mover, "MOVER");
		moverThread.start();
		
		Reader reader = new Reader(semaphore);
		Thread timeConsumerThread = new Thread(reader, "READER");
		timeConsumerThread.start();

	}

}
