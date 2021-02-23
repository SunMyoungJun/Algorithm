package com.ssafy.hw8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;




public class ProductMgrImpl extends Thread implements IProductMgr{
	private ArrayList<Product> products =null;

	private int size;

	private static ProductMgrImpl productMgrImpl =null;

	private ProductMgrImpl() {
		products = new ArrayList<>();
		load();

	}
	public static ProductMgrImpl getInstance() {
		if(productMgrImpl == null)
			productMgrImpl = new ProductMgrImpl();
		return productMgrImpl;
	}



	public void add(Product product) throws DuplicateException{
		for(int i=0;i<products.size();i++)
		{
			if(products.get(i).getNum() == product.getNum())  //이미 존재할 때 예외 발생
			{
//				throw new DuplicateException("같은 상품 존재 : "+product.getNum());
//				System.out.println("이미 존재하는 상품입니다.");
				return;
			}
		}
		products.add(product);
	}


	public void list() {
		for(int i=0; i<products.size();i++)
		{
			System.out.println(products.get(i));
		}	

	}

	public void list(int num) throws CodeNotFountException{

		for(int i=0;i<products.size();i++)
		{
			if(products.get(i).getNum() ==num)
			{
				System.out.println(products.get(i));
				return;
			}

		}

		throw new CodeNotFountException("존재하지 않는 삼품번호 : "+num);

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

	public ArrayList<Refrigerator> getRefrigeratorinfo400() throws ProductNotFoundException {
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

		if(temp2.size() ==0)
			throw new ProductNotFoundException("400이상 냉장고 없음 !");

		return temp2;
	}
	public ArrayList<TV> getTVinfo50() throws ProductNotFoundException {
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
		if(temp2.size()==0)
			throw new ProductNotFoundException("50인치 이상 TV없음!");
		return temp2;
	}


	public void load() {
		File f=new File("product.dat");
		if(f.exists()) {
			try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(f))){
				products = (ArrayList<Product>)in.readObject();
			} catch (IOException e) {
				System.out.println("오류 1 : "+e.getMessage());
			}
			catch(ClassNotFoundException e) {
				System.out.println("오류 2 : "+e.getMessage());
			}
		}
	}

	public void save() {
		File f = new File("product.dat");
		try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(f))){
			out.writeObject(products);
			out.flush();
			System.out.println("파일 저장 성공");
		} catch (IOException e) {
			System.out.println("오류 3 : "+e.getMessage());
		}
	}

	@Override
	public void run() {
		save();
	}

}





