package use.blocking.queue;
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
			
			try (Stream<Path> paths = Files.walk(Paths.get("D:/JavaThreads/Incoming"))) {
			    paths
			        .filter(Files::isRegularFile)
			        .forEach((original) -> {
			        	Path copy = Paths.get("D:/JavaThreads/Process/" + original.getFileName());
						try {
							Files.move(original, copy, StandardCopyOption.ATOMIC_MOVE);
							System.out.println("Moving files - " + copy.getFileName() + " - " + Thread.currentThread().getName());
							semaphore.getFiles().put(copy.toFile());
							
						} catch (IOException e) {
							e.printStackTrace();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					});
			    
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
