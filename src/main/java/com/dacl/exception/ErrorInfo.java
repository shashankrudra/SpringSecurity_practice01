package com.deloitte.ucl.exception;

public class ErrorInfo {

	public final String url;
    public final String ex;

    /**
     * @param url the url
     * @param exceptionMessage the exception message
     */
    public ErrorInfo(String url, String exceptionMessage) {
        this.url = url;
        this.ex = exceptionMessage;
    }

}
