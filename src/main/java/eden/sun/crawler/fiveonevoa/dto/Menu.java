package eden.sun.crawler.fiveonevoa.dto;

public class Menu {
	private String title;
	private String link;
	private int level;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return "Menu [title=" + title + ", link=" + link + ", level=" + level
				+ "]";
	}
	
}
