package use.wait.notify;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

public class Mover implements Runnable {
	
	private Semaphore semaphore;
	private boolean killMover;
	
	public Mover(Semaphore semaphore) {
		this.semaphore = semaphore;
		this.killMover = false;
	}

	@Override
	public void run() {
		while(!killMover) {
			
			if (semaphore.isProcessingQueueAtMaxCapacity()) {
				semaphore.waitOnFullQueue();
			}
			
			try (Stream<Path> paths = Files.walk(Paths.get("D:/JavaThreads/Incoming"))) {
			    paths
			        .filter(Files::isRegularFile)
			        .forEach((original) -> {
			        	Path copy = Paths.get("D:/JavaThreads/Process/" + original.getFileName());
						try {
							Files.move(original, copy, StandardCopyOption.ATOMIC_MOVE);
							System.out.println("Moving files - " + copy.getFileName() + " - " + Thread.currentThread().getName());
							semaphore.addFileToProcess(copy.toFile());
							if (!semaphore.isNoMoreFilesLeftToProcess()) {
								semaphore.notifyToStartProcessing();
								
							} 
						} catch (IOException e) {
							e.printStackTrace();
						}
					});
			    
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
