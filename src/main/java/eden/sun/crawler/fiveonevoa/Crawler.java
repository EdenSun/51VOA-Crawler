package eden.sun.crawler.fiveonevoa;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import eden.sun.crawler.exception.CrawlerException;
import eden.sun.crawler.fiveonevoa.dto.Article;
import eden.sun.crawler.fiveonevoa.dto.Menu;
import eden.sun.crawler.util.ErrorCode;

public class Crawler {
	private static final Logger logger = Logger.getLogger(Crawler.class);
	private static final int CONNECT_TIMEOUT = 8000;
	private static final String SOURCE_URL = "http://www.51voa.com/";
	private Document homeDoc;
	
	private Crawler() {}

	private static class CrawlerHolder {
		private static final Crawler INSTANCE = new Crawler();
	}

	public static final Crawler getInstance() {
		logger.info("retrieve 51voa crawler instance.");
		return CrawlerHolder.INSTANCE;
	}
	
	public void init() throws CrawlerException{
		try {
			logger.info("fetching html from " + SOURCE_URL);
			homeDoc = Jsoup.connect(SOURCE_URL).timeout(CONNECT_TIMEOUT).get();
			logger.info("fetching html from " + SOURCE_URL + " done.");
			
		} catch (IOException e) {
			logger.error("Initialize 51voa crawler error.",e);
			throw new CrawlerException("Initialize 51voa crawler error.",ErrorCode.INIT_ERROR,e);
		}
	}
	
	public List<Menu> loadMenuList() throws CrawlerException{
		if( homeDoc == null ){
			throw new CrawlerException("Fetched document is empty.",ErrorCode.EMPTY_DOCUMENT_ERROR);
		}
		try {
			List<Menu> menuList = new ArrayList<Menu>();
			Menu menu = null;
			Element leftNav = homeDoc.getElementById("left_nav");
			Elements childOfleftNav = leftNav.children();
			for(int i=0 ;i <childOfleftNav.size();i++){
				
				Element child = childOfleftNav.get(i);
				
				if( child.hasClass("left_nav_title") ){
					menu = new Menu();
					menu.setLevel(0);
					menu.setTitle(child.text());
					if( child.select("a").size() != 0 ){
						menu.setLink(child.child(0).attr("abs:href"));
					}
					
					menuList.add(menu);
				}else{
					if( child.tagName().equals("ul") ){
						Elements liList = child.children();
						if( liList.size() > 0 ){
							for(int j=0 ; j < liList.size() ;j ++ ){
								menu = new Menu();
								Element li = liList.get(j);
								menu.setLevel(1);
								menu.setLink( li.child(0).attr("abs:href"));
								menu.setTitle( li.text() );
								
								menuList.add(menu);
							}
						}
					}
				}
			}
			
			return menuList;
		} catch (Exception e) {
			logger.error(e);
			throw new CrawlerException("Parse html error.",ErrorCode.PARSE_HTML_ERROR);
		}
	}

	
	public List<Article> loadHomeArticleList() throws CrawlerException{
		if( homeDoc == null ){
			throw new CrawlerException("Fetched document is empty.",ErrorCode.EMPTY_DOCUMENT_ERROR);
		}
		List<Article> articles = new ArrayList<Article>();
		Article article = null;
		Elements articleList = homeDoc.select("#list > ul > li");
		
		DateFormat updateDateDateFormat = new SimpleDateFormat("yyyy-mm-dd");
		if( articleList.size() > 0 ){
			for(int i=0 ; i < articleList.size() ; i++ ){
				article = new Article();
				Element articleLi = articleList.get(i);

				Elements anchorsInLi = articleLi.select("> a");
				for(int j=0; j< anchorsInLi.size() ; j++ ){
					Element anchor = anchorsInLi.get(j);
					
					if( anchor.select("font").size() != 0 ){
						String category = anchor.select("font").text().trim();
						category = category.substring(1, category.length()-1);
						
						article.setCategory(category);
					}else if( anchor.select("img").size() != 0 ){
						Elements imgs = anchor.select("img");
						for( int imgIndex = 0 ; imgIndex < imgs.size() ; imgIndex ++ ){
							Element img = imgs.get(imgIndex);
							if( img.attr("src").equalsIgnoreCase("/images/lrc.gif") ){
								article.setHasLyric(true);
							}else if( img.attr("src").equalsIgnoreCase("/images/yi.gif") ){
								article.setHasTranslation(true);
							}
						}
					}else{
						article.setUrl( anchor.attr("abs:href") );
						String title = anchor.text();
						title = title.substring(0, title.indexOf("("));
						article.setTitle(title);
						
						String updateDateStr = anchor.text().substring(anchor.text().indexOf("(")+1, anchor.text().length()-1);
						try {
							article.setUpdateDate(updateDateDateFormat.parse(updateDateStr));
						} catch (ParseException e) {
							logger.error("Can not parse update date of article:" + title,e);
						}
					}
					
					articles.add(article);
				}
			}
			return articles;
		}
		return null;
	}
}
