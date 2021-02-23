package com.ssafy.hw8;

import java.util.ArrayList;

public interface IProductMgr {
	public void add(Product product) throws DuplicateException;
	public void list();
	public void list(int num) throws CodeNotFountException;
	public ArrayList<Product> list(String name);
	public void delete(int num);
	public void priceList(int price);
	public ArrayList<Product> getTVinfo();
	public ArrayList<Product> getRefrigeratorinfo();
	public int getTotalPrice();
	public ArrayList<Refrigerator> getRefrigeratorinfo400() throws ProductNotFoundException;
}
