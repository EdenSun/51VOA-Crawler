package eden.sun.crawler.fiveonevoa;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import eden.sun.crawler.exception.CrawlerException;
import eden.sun.crawler.fiveonevoa.dto.Article;
import eden.sun.crawler.fiveonevoa.dto.Menu;


public class CrawlerTest{
	private static final Logger logger = Logger.getLogger(CrawlerTest.class);
	
	@Test
	public void loadMenuListTest() throws CrawlerException{
		Crawler crawler = Crawler.getInstance();
		crawler.init();
		List<Menu> menuList = crawler.loadMenuList();
		if( menuList != null ){
			for(int i =0 ;i< menuList.size() ;i++ ){
				logger.debug(menuList.get(i));
			}
		}
	}
	
	@Test
	public void loadHomeArticleListTest() throws CrawlerException{
		Crawler crawler = Crawler.getInstance();
		crawler.init();
		List<Article> articleList = crawler.loadHomeArticleList();
		if( articleList != null ){
			for(int i =0 ;i< articleList.size() ;i++ ){
				logger.debug(articleList.get(i));
			}
		}
	}
	
}