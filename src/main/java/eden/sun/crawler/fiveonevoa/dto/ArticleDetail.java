package eden.sun.crawler.fiveonevoa.dto;


public class ArticleDetail extends Article{
	/**
	 * 内容图片
	 */
	private String contentImageUrl;

	/**
	 * mp3地址
	 */
	private String mp3Url;
	/**
	 * lrc 地址
	 */
	private String lyricUrl;
	/**
	 * 翻译地址
	 */
	private String translationUrl;
	
	/**
	 * 文章内容
	 */
	private String content;
	
	/**
	 * 撰稿人
	 */
	private String byline;
	
	/**
	 * 刊登日期
	 */
	private String bylineDate;

	public String getContentImageUrl() {
		return contentImageUrl;
	}

	public void setContentImageUrl(String contentImageUrl) {
		this.contentImageUrl = contentImageUrl;
	}

	public String getMp3Url() {
		return mp3Url;
	}

	public void setMp3Url(String mp3Url) {
		this.mp3Url = mp3Url;
	}

	public String getLyricUrl() {
		return lyricUrl;
	}

	public void setLyricUrl(String lyricUrl) {
		this.lyricUrl = lyricUrl;
	}

	public String getTranslationUrl() {
		return translationUrl;
	}

	public void setTranslationUrl(String translationUrl) {
		this.translationUrl = translationUrl;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getByline() {
		return byline;
	}

	public void setByline(String byline) {
		this.byline = byline;
	}

	public String getBylineDate() {
		return bylineDate;
	}

	public void setBylineDate(String bylineDate) {
		this.bylineDate = bylineDate;
	}
	
}
