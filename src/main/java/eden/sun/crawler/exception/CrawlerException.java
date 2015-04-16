package eden.sun.crawler.exception;

public class CrawlerException extends Exception{
	private String errorCode;
	
	public CrawlerException(String message, String errorCode,Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	public CrawlerException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

}
