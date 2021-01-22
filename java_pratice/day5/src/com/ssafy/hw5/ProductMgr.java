package com.ssafy.hw5;

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
}
