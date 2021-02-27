package com.ssafy.news;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class NewsDAOSAXImpl implements INewsDao {
	List<News> list = new ArrayList<News>();

	@Override
	public List<News> getNewsList(String url) {
		connectNews(url);
			return list;
	}

	@Override
	public News search(int index) {
		return null;
	}

	class SAXHandler extends DefaultHandler {
		private List<News> list = new ArrayList<News>();
		News news;
		String s="";
		public List<News> getList() {
			return list;
		}
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			if(qName.equalsIgnoreCase("title")) {
				news = new News();
			}
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			switch(qName) {
				case "title" :
					news.setTitle(s);
					break;
					
				case "link" :
					news.setLink(s);
					break;
					
				case "description":
					news.setDesc(s);
					list.add(news);
					break;
				
//				case "item":
//					list.add(news);
//					break;
			}
			
		}

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			s = new String(ch,start,length);
			s.trim();
		}
		
	}
	
	
	public void connectNews(String in_url) {
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = null;
		try {
			parser = factory.newSAXParser();
			SAXHandler handler = new SAXHandler();
			URL url = null;
			url = new URL(in_url);
			InputStream is = url.openConnection().getInputStream(); 
			parser.parse(is, handler);
			list = handler.getList();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
