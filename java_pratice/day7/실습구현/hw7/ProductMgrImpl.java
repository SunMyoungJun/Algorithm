package com.ssafy.hw7;

import java.util.ArrayList;

public class ProductMgrImpl implements IProductMgr{
	private ArrayList<Product> products =null;
	
	private int size;

	private static ProductMgrImpl productMgrImpl =null;

	private ProductMgrImpl() {
		products = new ArrayList<>(); 
	}
	public static ProductMgrImpl getInstance() {
		if(productMgrImpl == null)
			productMgrImpl = new ProductMgrImpl();
		return productMgrImpl;
	}
	
	
	
	
	public void add(Product product)
	{
		products.add(product);
	}
		
	
	public void list() {
		for(int i=0; i<products.size();i++)
		{
			System.out.println(products.get(i));
		}	

	}

	public void list(int num) {

		for(int i=0;i<products.size();i++)
		{
			if(products.get(i).getNum() ==num)
				System.out.println(products.get(i));
		}
	}

	public ArrayList<Product> list(String name) {
		ArrayList<Product> temp = new ArrayList<>();
		for(int i=0;i<products.size();i++)
		{
			if(products.get(i).getName().contains(name))
				temp.add(products.get(i));
		}
		return temp;
	}

	public void delete(int num) {
		for(int i=0; i<products.size();i++)
		{
			if(products.get(i).getNum() ==num)
			{
				products.remove(i);
				break;
			}

		}
	}
	public void priceList(int price) {
		for(int i=0;i<products.size();i++)
		{
			if(products.get(i).getPrice() <= price)
				System.out.println(products.get(i));
		}

	}

	

	public ArrayList<Product> getTVinfo() {
		ArrayList<Product> temp = new ArrayList<>();
		for(Product product : products)
		{
			if(product instanceof TV)
			{
				temp.add(product);
			}
		}

		return temp;
	}

	public  ArrayList<Product> getRefrigeratorinfo() {
		 ArrayList<Product> temp = new ArrayList<>();

		for(Product product : products)
		{
			if(product instanceof Refrigerator)
			{
				temp.add(product);
			}
		}

	
		return temp;
	}

	public int getTotalPrice() {
		int sum =0;

		for(int i=0;i<products.size();i++)
		{
			sum += products.get(i).getPrice() * products.get(i).getStock();
		}


		return sum;
	}

	public ArrayList<Refrigerator> getRefrigeratorinfo400() {
		ArrayList<Refrigerator> temp = new ArrayList<>();
		for(int i=0;i<products.size();i++)
		{
			if(products.get(i) instanceof Refrigerator)
				temp.add((Refrigerator)products.get(i));		
		}
		ArrayList<Refrigerator> temp2 = new ArrayList<>();
		for(int i=0;i<temp.size();i++)
		{
			if(temp.get(i).getProductSize() >=400)
				temp2.add(temp.get(i));
				
		}
		return temp2;
	}
	public ArrayList<TV> getTVinfo50() {
		ArrayList<TV> temp = new ArrayList<>();
		for(int i=0;i<products.size();i++)
		{
			if(products.get(i) instanceof TV)
				temp.add((TV)products.get(i));		
		}
		ArrayList<TV> temp2 = new ArrayList<>();
		for(int i=0;i<temp.size();i++)
		{
			if(temp.get(i).getInch() >=50)
				temp2.add(temp.get(i));
				
		}
		return temp2;
	}
	
	
	
	
}