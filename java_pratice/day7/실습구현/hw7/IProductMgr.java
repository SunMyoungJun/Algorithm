package com.ssafy.hw7;

import java.util.ArrayList;

public interface IProductMgr {
	public void add(Product product);
	public void list();
	public void list(int num);
	public ArrayList<Product> list(String name);
	public void delete(int num);
	public void priceList(int price);
	public ArrayList<Product> getTVinfo();
	public ArrayList<Product> getRefrigeratorinfo();
	public int getTotalPrice();
	public ArrayList<Refrigerator> getRefrigeratorinfo400();
}
