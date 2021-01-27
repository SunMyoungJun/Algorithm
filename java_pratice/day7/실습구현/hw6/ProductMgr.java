package com.ssafy.hw6;

public class ProductMgr {

	private Product[] products = new Product[100]; // 최대 100개까지
	 private int size;
	
	 private static ProductMgr productMgr =null;
	
	private ProductMgr() {
		
	}
	public void add(Product product){
		
		products[size] = product;
		size++;
		
	}
	public void list() {
		for(int i=0; i<size;i++)
		{
			System.out.println(products[i]);
		}	
		
	}
	
	public void list(int num) {
		
		for(int i=0;i<size;i++)
		{
			if(products[i].getNum() ==num)
				System.out.println(products[i]);
		}
	}
	
	public Product[] list(String name) {
		Product[] temp =null;
		int cnt=0;
		for(int i=0;i<size;i++)
		{
			if(products[i].getName().contains(name))
				cnt++;
		}
		temp = new Product[cnt];
		int idx =0;
		for(int i=0;i<size;i++)
		{
			if(products[i].getName().contains(name))
			{
				temp[idx] = products[i];
				idx++;
			}
		}
		
		return temp;
	}
	
	public void delete(int num) {
		for(int i=0; i<size;i++)
		{
			if(products[i].getNum() ==num)
			{
				for(int j=i;j<size-1;j++)
				{
					products[j] = products[j+1];
				}
				size--;
				break;
			}
			
		}

		for(int i=0;i<size;i++)
			System.out.println(products[i]);
	}
	public void priceList(int price) {
		for(int i=0;i<size;i++)
		{
			if(products[i].getPrice() <= price)
				System.out.println(products[i]);
		}
		
	}
	
	public static ProductMgr getInstance() {
		if(productMgr == null)
			productMgr = new ProductMgr();
		return productMgr;
	}
	
	public Product[] getTVinfo() {
		Product[] temp = null;
		int cnt =0;
		
		for(Product product : products)
		{
			if(product instanceof TV)
			{
				cnt++;
			}
		}
		
		temp = new Product[cnt];
		int cnt2=0;
		for(int i=0; i<products.length;i++)
		{
			if(products[i] instanceof TV)
			{
				temp[cnt2] = products[i];
				cnt2++;
			}
		}
		
		return temp;
	}
	
	public Product[] getRefrigeratorinfo() {
		Product[] temp = null;
		int cnt =0;
		
		for(Product product : products)
		{
			if(product instanceof Refrigerator)
			{
				cnt++;
			}
		}
		
		temp = new Product[cnt];
		int cnt2=0;
		for(int i=0; i<products.length;i++)
		{
			if(products[i] instanceof Refrigerator)
			{
				temp[cnt2] = products[i];
				cnt2++;
			}
		}
		
		return temp;
	}
	
	public int getTotalPrice() {
		int sum =0;
		
		for(int i=0;i<size;i++)
		{
			sum += products[i].getPrice() * products[i].getStock();
		}
		
		
		return sum;
	}
	
	
	
	
	
}
