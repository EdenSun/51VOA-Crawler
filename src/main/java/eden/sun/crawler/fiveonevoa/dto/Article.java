package eden.sun.crawler.fiveonevoa.dto;

import java.util.Date;
import java.util.List;

public class Article {
	private String title;
	private String category;
	private boolean hasTranslation;
	private boolean hasLyric;
	private Date updateDate;
	private String url;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public boolean isHasTranslation() {
		return hasTranslation;
	}
	public void setHasTranslation(boolean hasTranslation) {
		this.hasTranslation = hasTranslation;
	}
	public boolean isHasLyric() {
		return hasLyric;
	}
	public void setHasLyric(boolean hasLyric) {
		this.hasLyric = hasLyric;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Article [title=" + title + ", category=" + category
				+ ", hasTranslation=" + hasTranslation + ", hasLyric="
				+ hasLyric + ", updateDate=" + updateDate + ", url=" + url
				+ "]";
	}
	
}
