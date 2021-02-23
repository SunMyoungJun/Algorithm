package com.ssafy.hw8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


class DuplicateException extends Exception{

	public DuplicateException(String message) {
		super(message);
	}
}

class CodeNotFountException extends Exception{

	public CodeNotFountException(String message) {
		super(message);

	}
	
}
	
class ProductNotFoundException extends Exception{

	public ProductNotFoundException(String message) {
		super(message);
	}
	

}





public class ProductTest {

	public static void main(String[] args) throws IOException, DuplicateException, CodeNotFountException,ProductNotFoundException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int test =4;
		Product product;
		ProductMgrImpl pmgr =ProductMgrImpl.getInstance();
		System.out.println("**********원래 있던 product.dat 파일 목록 리스트 출력 ***********");
		pmgr.list();
		System.out.println("**********원래 있던 product.dat 파일 목록 리스트 출력 끝 ***********");

//		pmgr.load();  //////////////////////////////////////////////////여기 안쓰고 ProductMgrImpl 생성자 안에 썻음.



			pmgr.add(new Product(12345,"샘성라디오",55000,2,"고음질")); //	
			pmgr.add(new Refrigerator(23455,"삼성냉장고1",1800000,4,"큰타입",200,"blue"));
			pmgr.add(new Refrigerator(54678,"삼성냉장고3",870000,5,"가성비굿",300,"yellow"));
			pmgr.add(new Product(23125,"샘성에어컨23",255000,1,"엄청시원")); 
			pmgr.add(new TV(5555,"삼성TV111번",1500000,7,"HD",48));
			pmgr.add(new Refrigerator(8876,"삼성냉장고2",1200000,2,"제일시원",350,"green"));
			pmgr.add(new TV(686696,"삼성TV2번",1200000,3,"HD",26));
			product = new Product(78543,"샘성선풍기3",157000,5,"강풍지원"); 			
			pmgr.add(new TV(3334333,"삼성TV8번",870000,7,"HD",22));
			pmgr.add(new TV(5551255,"삼성TV7번",1270000,12,"HD",49));
			pmgr.add(product);


		
		
		
		System.out.println("**********리스트 출력 ***********");
		pmgr.list();

		
		System.out.println("---------------------");
		Scanner sc = new Scanner(System.in);
		System.out.println("같은 제품번호로 제품을 저장해보자 제품 정보입력 ! (번호,이름,가격,재고,타입)");
		int tnum = sc.nextInt();
		String tname = sc.next();
		int tprice = sc.nextInt();
		int tstock = sc.nextInt();
		String ttype = sc.next();
		try
		{
		pmgr.add(new Product(tnum,tname,tprice,tstock,ttype));
		}
		catch(DuplicateException e){
			System.out.println(e.getMessage());
		}
		
		System.out.println("--------------------------");
		System.out.println("없는 상품번호 검색해보자!!");
		st = new StringTokenizer(br.readLine());
		int ttnum = Integer.parseInt(st.nextToken());

		try {
			pmgr.list(ttnum);
		}catch(CodeNotFountException e)
		{
			System.out.println(e.getMessage());
		}

		
		
		
		System.out.println("**********12345 검색 대상 출력***********");
		pmgr.list(12345);
		
//		System.out.println("삭제할 번호를 입력하세요");
//		num2 = Integer.parseInt(br.readLine());
		System.out.println("**********12345 삭제 후 출력 ***********");
		pmgr.delete(12345);
		pmgr.list();
		System.out.println("1200000원까지 출력");
//		num2 = Integer.parseInt(br.readLine());
		System.out.println("**********특정 가격 이하 리스트 출력 ***********");
		pmgr.priceList(1200000);

		
		System.out.println("****************************");
		System.out.println("TV정보만 검색");
		
		ArrayList<Product> products = pmgr.getTVinfo();
		
		for(Product p1 : products)
			System.out.println(p1);
	
		System.out.println("****************************");
		System.out.println("냉장고 정보만 검색");

		ArrayList<Product> products2 = pmgr.getRefrigeratorinfo();
		for(Product p1 : products2)
			System.out.println(p1);
		System.out.println("****************************");
		System.out.println("상품명으로 삼품을 검색(상품명에 냉장고 들어간거 검색)");
		
		ArrayList<Product> products3 = pmgr.list("냉장고");
		for(Product p1 : products3)
			System.out.println(p1);
		
		System.out.println("****************************");
		System.out.println("전체 재고 상품 금액 구하기(재고수량 곱해야함)");
		
		int sum = pmgr.getTotalPrice();
		System.out.println("전체 재고 상품 금액 : "+sum);
		
		
		System.out.println("****************************");
		System.out.println("400L 이상의 냉장고만 검색(현재 400이상 안넣어둿음 확인하려고)");
		try {
		ArrayList<Refrigerator> Reproduct = pmgr.getRefrigeratorinfo400();
		for(Refrigerator rf : Reproduct)
			System.out.println(rf);
		}
		catch(ProductNotFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("****************************");
		System.out.println("50inch이상의 TV만 검색(현재 50이상 안넣어뒀음 예외처리 확인하려고");
		try {
			ArrayList<TV> Tvproduct = pmgr.getTVinfo50();
			for( TV tv1 : Tvproduct)
				System.out.println(tv1);
		}catch(ProductNotFoundException e) {
			System.out.println(e.getMessage());
		}
	
	
	pmgr.start();
	
	}
}