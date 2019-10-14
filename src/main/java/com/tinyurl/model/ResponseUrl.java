package com.tinyurl.model;

public class ResponseUrl {
	private String url;
	
	public ResponseUrl(){}
	
	public ResponseUrl(String url){
		this.url = url;
	}
	
	
	public void setUrl(String url){
		this.url = url;
	}
	
	public String getUrl(){
		return this.url;
	}
}
