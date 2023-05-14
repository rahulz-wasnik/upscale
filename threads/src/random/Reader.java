package random;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Reader implements Runnable {

	@Override
	public void run() {
		try (Stream<Path> paths = Files.walk(Paths.get("D:/JavaThreads/Incoming"))) {
			paths
			.filter(Files::isRegularFile)
			.filter(Files::isReadable)
			.forEach((original) -> {
				
//				File file = new File("D:/JavaThreads/Copy/"+ original.getFileName());
//				try (OutputStream outputStream = new FileOutputStream(file)) {
//					Files.copy(original, outputStream);
//				} catch (FileNotFoundException e) {
//					e.printStackTrace();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
				
//				try (InputStream inputStream = Files.newInputStream(original, StandardOpenOption.READ)) {
//					File file = new File("D:/JavaThreads/Copy/copied.pdf");
//					try (OutputStream outputStream = new FileOutputStream(file)) {
//						byte[] buffer = new byte[1024];
//						int bytesRead;
//						while ((bytesRead = inputStream.read(buffer)) > 0) {
//							outputStream.write(buffer, 0, bytesRead);
//						}
//					}
//
//				} catch (IOException e1) {
//					e1.printStackTrace();
//				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
