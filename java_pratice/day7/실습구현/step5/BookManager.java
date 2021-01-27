package com.ssafy.ws04.step5;

import java.util.ArrayList;
import java.util.Arrays;

public class BookManager {
	
	ArrayList<Book> list =null;
	
	private final int MAX_SIZE = 100;
	private Book[] books = new Book[MAX_SIZE];
	private int size = 0;
	
	private static BookManager manager = null;
	
	private BookManager(){
//		생성하면서 멤버 객체 생성관리
		list = new ArrayList<>();
	}
	
	public static BookManager getInstance() {
		if(manager == null) {
			manager = new  BookManager();
		}
		return manager;
	}
	
//	public BookManager(){
//		books = new Book[MAX_SIZE];
//	}
	
//	이름이 유사한 것 찾아서 반환하기 .(제목에 이름을 포함하면 반환)
	public ArrayList<Book> searchByTitle(String title) {
		ArrayList<Book> temp = new ArrayList<>();
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getTitle().contains(title)) {  //문자안에 일치하는 부분 있으면
				temp.add(list.get(i));
			}
		}
		return temp;
	}
	
	
	
//	전체 가격 반환하기
	public int getTotalPrice() {
		int tot =0;
		for(Book book : list) {
			tot +=book.getPrice();
		}
		
		
		return tot;
	}
	
//	전체 평균 가격 double 타입으로 반환하기
	public double getPriceAvg() {
		double price =0;
		int tot = getTotalPrice();
		price = (double)tot / list.size();
		return price;
	}
	
	
	public void add(Book book) {
		list.add(book);
	}
	public void remove(String isbn) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getIsbn().equals(isbn)) {
				list.remove(i);
				return;
			}
		
		
		}

		return;
	}
	public ArrayList<Book> getList() {
		return list;
	}
	public Book searchByIsbn(String isbn) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getIsbn(). equals(isbn)) {
				return list.get(i);
			}
		}
		return null;
	}
	public void update(String isbn, String title) {
		for(int i = 0; i < list.size(); i++) {
			if(isbn.equals(list.get(i).getIsbn())) {
				list.get(i).setTitle(title);
			}
		}
	}
	public ArrayList<Book> getMagazines() {
		ArrayList<Book> temp = new ArrayList<>();
		int cnt =0;
		for(Book book : list){
			if(book instanceof Magazine) {  //instanceof Book은 해버리면 매가진도 북이라서 모두 출력됨..
				temp.add(book);
			}
			
		}

		return temp;
	}
	public ArrayList<Book> getBooks() {
		ArrayList<Book> temp =new ArrayList<>();
	
		int idx=0;
		for(Book book : list) {
			if( !(book instanceof Magazine)) {
				temp.add(book);
			}
		
		}
		return temp;
	}
	
	
	
}








