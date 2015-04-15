package eden.sun.crawler.fiveonevoa;

import org.apache.log4j.Logger;

public class Crawler {
	private static final Logger logger = Logger.getLogger(Crawler.class);

	private Crawler() {}

	private static class CrawlerHolder {
		private static final Crawler INSTANCE = new Crawler();
	}

	public static final Crawler getInstance() {
		logger.info("retrieve 51voa crawler instance.");
		return CrawlerHolder.INSTANCE;
	}

	/*public static void main(String[] args) {
		System.out.println("hello,crawler from println");
		logger.info("Hello, Crawler. ");
	}*/
}
