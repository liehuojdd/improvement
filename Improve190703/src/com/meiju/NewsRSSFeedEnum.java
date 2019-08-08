package com.meiju;

public enum NewsRSSFeedEnum {
	YAHOO_TOP_STORIES("<a href=http://rss.news.yahoo.com/rss/topstories><code>http://rss.news.yahoo.com/rss/topstories</code></a>"),    
	CBS_TOP_STORIES("<a href=http://feeds.cbsnews.com/CBSNewsMain?format=xml><code>http://feeds.cbsnews.com/CBSNewsMain?format=xml</code></a>"), 	    
	LATIMES_TOP_STORIES("<a href=http://feeds.latimes.com/latimes/news?format=xml><code>http://feeds.latimes.com/latimes/news?format=xml</code></a>"); 
		        	
	private String rss_url;
	private NewsRSSFeedEnum(String rss) {
		this.rss_url=rss;
	}
	public String getRssURL() {
		return this.rss_url;
	}
}
