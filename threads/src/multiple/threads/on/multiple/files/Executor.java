package multiple.threads.on.multiple.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Executor {

	public static void main(String args[]) throws IOException {

		List<File> files = Files.walk(Paths.get("D:/JavaThreads/Incoming")).filter(Files::isRegularFile)
				.map((original) -> original.toFile()).collect(Collectors.toList());

		if (!files.isEmpty()) {
			final int numberOfThreads = 4;
			Thread[] threads = new Thread[numberOfThreads];

			final int filesPerThread = files.size() / numberOfThreads;
			final int remainingFiles = files.size() % numberOfThreads;

			for (int i = 0; i < numberOfThreads; i++) {

				final int threadNumber = i;
				threads[threadNumber] = new Thread() {

					@Override
					public void run() {
						List<File> fileToThreadMappingList = new ArrayList<>();
						for (int i = threadNumber * filesPerThread; i < (threadNumber + 1) * filesPerThread; i++) {
							
							fileToThreadMappingList.add(files.get(i));
							if (remainingFiles > 0 && threadNumber == (numberOfThreads - 1)) {
								for (int j = files.size() - remainingFiles; j < files.size(); j++) {
									fileToThreadMappingList.add(files.get(j));
								}
							}							

						}

						Iterator<File> iterator = fileToThreadMappingList.iterator();
						while (iterator.hasNext()) {
							File file = iterator.next();
							System.out.println(
									"file - " + file.getName() + " processed by " + Thread.currentThread().getName());
						}
					}
				};
			}

			for (Thread t : threads) {
				t.start();
			}
			
			for (Thread t : threads) {
				try {
					t.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			System.out.println("Ends - " + Thread.currentThread().getName());

		}

	}
}
