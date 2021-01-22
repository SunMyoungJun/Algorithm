package com.ssafy.ws04.step3;

public class BookManager {
	private final int MAX_SIZE = 100;
	private Book[] books = new Book[MAX_SIZE];
	private int size;


	
	public void add(Book book) {
		if(size < MAX_SIZE -1)
		{
			books[size] = book;
			size++;	
		}
		
	}
	public void remove(String isbn) {
		for(int i = 0; i<size;i++)
		{
			if(isbn.equals(books[i].getIsbn()))
			{
				for(int j=i;j<size-1;j++)
				{
					books[j] = books[j+1];
				}
				size--;
				break;
			}
		}
		System.out.println("삭제완료");
	}
	public Book[] getList() {
		Book[] temps = new Book[size];
		for(int i=0; i<size; i++)  //사이즈만큼만 주자(실제 있는만큼)
		{
			temps[i] = books[i];
		}
		return temps;
	}
	public Book searchByIsbn(String isbn) {
		for(int i=0;i<size;i++)
		{
			if(isbn.equals( books[i].getIsbn()))
				return books[i];
		}
		
		return null; //도서 리스트에 없으면 null 반환
	}
	
	public void update(String isbn,String title) {
		for(int i=0;i<size;i++)
		{
			if(isbn.equals( books[i].getIsbn()))
				{
					books[i].setTitle(title);
				}
		}
	}
	
	
	
	
}
