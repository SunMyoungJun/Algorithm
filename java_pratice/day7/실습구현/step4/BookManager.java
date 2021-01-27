package com.ssafy.ws04.step4;

import java.util.Arrays;

public class BookManager {
	private final int MAX_SIZE = 100;
	private Book[] books = new Book[MAX_SIZE];
	private int size = 0;
	
	private static BookManager manager = null;
	
	private BookManager(){
		
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
	public Book[] searchByTitle(String title) {
		Book[] temp = null;
		int cnt =0;
		for(int i=0; i<size;i++) {
//			if(books[i].getTitle().equals(title)) { //두 문자가 전체 일치
//				
//			}
			if(books[i].getTitle().contains(title)) {  //문자안에 일치하는 부분 있으면
				cnt++;
			}
		}
		temp = new Book[cnt];
		int idx =0;
		for(int i=0; i<size; i++) {
			if(books[i].getTitle().contains(title)) {  //문자안에 일치하는 부분 있으면
				temp[idx] = books[i];
				idx++;
			}
		}
		return temp;
	}
	
	
	
//	전체 가격 반환하기
	public int getTotalPrice() {
		int tot =0;
		for(int i=0;i<size;i++)
		{
			tot += books[i].getPrice();
		}
		
		
		return tot;
	}
	
//	전체 평균 가격 double 타입으로 반환하기
	public double getPriceAvg() {
		double price =0;
		int tot = getTotalPrice();
		price = (double)tot / size;
		return price;
	}
	
	
	public void add(Book book) {
		if(size < MAX_SIZE-1) {
			books[size] = book;
			size++;
		}
	}
	public void remove(String isbn) {
//		순서를 유지하지 않고 빠르게 삭제하기
		for(int i = 0; i < size; i++) {
			if(isbn.equals(books[i].getIsbn())) {
				books[i] = books[size-1];
				books[size-1] = null;
				size--;
				break;
			}
		}
////		순서를 유지하면서 삭제하기
//		for(int i = 0; i < size; i++) {
//			if(isbn.equals(books[i].getIsbn())) {
//				for(int j = i; j < size; j++) {
//					books[j] = books[j+1];
//				}
//				size--;
//				break;
//			}
//		}
//		for(int i = 0; i < size; i++) {
//			if(isbn.equals(books[i].getIsbn())) {
//				books[i] = null;
//				break;
////				return;
//			}
//		}
//		System.out.println("삭제완료");
		return;
	}
	public Book[] getList() {
		
		return Arrays.copyOf(books, size);
		
//		Book[] temps = Arrays.copyOf(books, size);
//		return temps;
		
//		Book[] temps = new Book[size];
//		
//		
////		System.arraycopy(books, 0, temps, 0, size);
////		for(int i = 0; i < size; i++) {
////			temps[i] = books[i];
////		}
//		
//		return temps;
//		return books;
	}
	public Book searchByIsbn(String isbn) {
		for(int i = 0; i < size; i++) {
			if(isbn.equals(books[i].getIsbn())) {
				return books[i];
			}
		}
		return null;
	}
	public void update(String isbn, String title) {
		for(int i = 0; i < size; i++) {
			if(isbn.equals(books[i].getIsbn())) {
				books[i].setTitle(title);
			}
		}
	}
	public Book[] getMagazines() {
		Book[] temp = null;
		int cnt =0;
		for(Book book : books){
			if(book instanceof Magazine) {  //instanceof Book은 해버리면 매가진도 북이라서 모두 출력됨..
				cnt++;
			}
		
			
		}
		
		temp = new Book[cnt];
		int idx=0;
		for(Book book : books) {
			if(book instanceof Magazine) {
				temp[idx] = book;
				idx++;
			}
			
		}
		return temp;
	}
	public Book[] getBooks() {
		Book[] temp =null;
		int cnt =0;
		for(Book book : books){
			if(book instanceof Magazine) {  //instanceof Book은 해버리면 매가진도 북이라서 모두 출력됨..
				
			}
			else {
				if(book != null)
					cnt++;
			}
			
		}
		
		temp = new Book[cnt];
		int idx=0;
		for(Book book : books) {
			if(book instanceof Magazine) {
				
			}
			else
			{
				if(book != null) {
					temp[idx] = book;
					idx++;
				}
			}
			
			
		}
		
		
		return temp;
	}
	
	
	
}








