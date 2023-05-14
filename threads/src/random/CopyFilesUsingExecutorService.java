package random;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CopyFilesUsingExecutorService {

	public static void main(String[] args) throws Exception {
		String soursePath = "D:/X";

		int threadCount = 5;
		List<File> files = getFileList(soursePath);
		List<File> threadFiles = new ArrayList<>();
		System.out.println("file size ->" + files.size());
		long start = System.currentTimeMillis();
		ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
		int fileCount = files.size() / threadCount;
		System.out.println("filecount - "+fileCount);
		int count = 0;
		List<Future<Boolean>> futList = new ArrayList<>();
		for (int i = 0; i < files.size(); i++) {
			count++;
			threadFiles.add(files.get(i));
			if (count == fileCount) {
				Future<Boolean> objFut = executorService.submit(new FileCopy(threadFiles));
				threadFiles = new ArrayList<>();
				count = 0;
				futList.add(objFut);
			}
		}
		
//		System.out.println("----------------------------------------------------------------");
//		System.out.println(threadFiles);
		Future<Boolean> objFut = executorService.submit(new FileCopy(threadFiles));
		futList.add(objFut);

		for (Future<Boolean> fut : futList) {
			fut.get();
		}

		executorService.shutdown();

		/*
		 * for(File file : files) { Files.copy(file.toPath(), (new File(destinationPath
		 * + file.getName())).toPath(), StandardCopyOption.REPLACE_EXISTING); }
		 */

		long end = System.currentTimeMillis();
		System.out.println("time taken - " + (end - start));
	}

	public static List<File> getFileList(String filePath) throws Exception {
		List<File> fileLst = new ArrayList<File>();
		File file = new File(filePath);
		if (file.isDirectory()) {
			for (File f : file.listFiles()) {
				if (!f.isDirectory()) {
					fileLst.add(f);
					continue;
				}
			}
			// File[] array = (File[]) fileLst.toArray(new
			// File[fileLst.size()]);
			return fileLst;
		} else {
			throw new Exception("The given path is not a Directory");
		}
	}
}

class FileCopy implements Callable<Boolean> {

	private List<File> files;

	public FileCopy(List<File> files) {
		super();
		this.files = files;
	}

	@Override
	public Boolean call() throws Exception {

		String destinationPath = "D:/X-copy/";
		boolean isCompleted = false;
		int count = 0;
		try {
			for (File file : files) {
				count++;
				Files.copy(file.toPath(), (new File(destinationPath + file.getName())).toPath(),
						StandardCopyOption.REPLACE_EXISTING);
			}
			isCompleted = true;
		} catch (Exception e) {
			e.printStackTrace();
			isCompleted = false;
		}
		System.out.println("Thread - "+Thread.currentThread().getName()+" has processed " + count);
		return isCompleted;
	}

}
