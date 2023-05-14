package random;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


class Task implements Runnable {

	@Override
	public void run() {
		System.out.println("I am running"+ Thread.currentThread().getName());
	}
	
}


public class ScheduleExecutorServiceMethods {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService executorService = Executors.newScheduledThreadPool(10);
		List<Task> tasks = new ArrayList<>();
		tasks.add(new Task());
		tasks.add(new Task());
		tasks.add(new Task());
		tasks.add(new Task());
		Future<?> f = executorService.submit(new Task());
		f.get();
		System.out.println(f.isDone());
		
		executorService.shutdown();
		try {
			if (executorService.awaitTermination(5000, TimeUnit.MILLISECONDS)) {
				executorService.shutdownNow();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	

}
