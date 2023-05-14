package java8newfeatures;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

public class RandomThings {

	  public static void main(String[] args) {
	        List<String> urlsToCrawl = List.of("https://masterdevskills.com");

	        RandomThings webCrawler = new RandomThings();
	        webCrawler.crawl(urlsToCrawl);
	    }

	    public void crawl(List<String> urlsToCrawl) {
	        urlsToCrawl.stream()
	                .map(urlToCrawl -> {
						try {
							return new URL(urlToCrawl);
						} catch (MalformedURLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						return null;
					})
	                .forEach(url -> {
						try {
							save(url);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					});
	    }

	    private void save(URL url) throws IOException {
	        String uuid = UUID.randomUUID().toString();
	        InputStream inputStream = url.openConnection().getInputStream();
	        Files.copy(inputStream, Paths.get(uuid + ".txt"), StandardCopyOption.REPLACE_EXISTING);
	    }
}
