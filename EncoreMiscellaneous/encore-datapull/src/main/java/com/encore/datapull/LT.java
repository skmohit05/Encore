package com.encore.datapull;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.encore.datapull.model.LTJobDetail;
import com.encore.datapull.parser.LTJobPageParser;
import com.encore.datapull.parser.LTResultsPageParser;


// Driver - https://chromedriver.storage.googleapis.com/index.html?path=88.0.4324.96/ - chromedriver_win32.zip
// chromedriver.exe must be in environment path, for the program to run

public class LT {

	private static final Logger logger = LogManager.getLogger(LT.class);


	private List<String> urls;

	public static void main(String[] args) {
		if (args.length != 1 && args.length != 3) {
			System.out.println("Usage com.encore.datapull.LT <URL> <StartLink(O)> <EndLink(O)>");
			System.out.println("Example com.encore.datapull.LT to pull links 3, 4, 5 from url - https://www.google.com 3 5");
			System.exit(0);
		}

		int startLink = args.length < 3 ? 1 : Integer.parseInt(args[1]);
		int endLink = args.length < 3 ? Integer.MAX_VALUE : Integer.parseInt(args[2]);

		if(startLink < 1 || endLink < 1) {
			System.out.println("Negative or Zero not allowed for start and end");
			System.exit(0);
		}

		new LT().process(args[0], startLink, endLink);

		Browser.getInstance().close();
	}

	public void process(final String mainUrl, final int startLink, final int endLink) {
		logger.info("Processing LT with parameters {}, {}, {} ", mainUrl, startLink, endLink);

		this.urls = this.getResultURLs(mainUrl, startLink, endLink);
		logger.info("Found {} links for processing", this.urls.size());
		for(String url : this.urls) {
			logger.info(url);
		}

		for(String url : this.urls) {
			logger.info("Processing URL: " + url);
			try {
				LTJobDetail jobDetail = DBUtil.getLTJobDetail(url);
				if (jobDetail == null) {
					int waitSeconds = RandomUtils.nextInt(5, 10);
					logger.info("Delay {}s before loading URL", waitSeconds);
					TimeUnit.SECONDS.sleep(waitSeconds);

					jobDetail = this.getJobDetail(url);
					DBUtil.upsertLT(url, jobDetail);
					logger.info("JobDetail URL {} loaded to database", url);
				} else {
					logger.info("JobDetail URL {} already present. Skipping processing", url);

				}
			} catch (Exception e) {
				logger.error("Error occured getting jobDetail url " + url, e);
			}
		}
	}

	private List<String> getResultURLs(final String mainUrl, final int startLink, final int endLink) {
		LTResultsPageParser parser = new LTResultsPageParser();
		List<String> resultUrls = parser.parse(mainUrl);
		if (resultUrls.size() == 0) {
			return resultUrls;
		}
		return resultUrls.subList(Math.max(0, startLink - 1), Math.min(resultUrls.size(), endLink));
	}

	private LTJobDetail getJobDetail(final String url) {
		LTJobPageParser jobParser = new LTJobPageParser();
		return jobParser.parse(url);
	}
}
