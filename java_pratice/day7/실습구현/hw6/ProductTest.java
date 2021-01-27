package com.ssafy.hw6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ProductTest {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int test =4;
		Product product;
		ProductMgr pmgr =ProductMgr.getInstance();
//		while(test !=0)   //키보드로 입력받기 ...
//		{
			System.out.println("상품번호, 삼품이름,가격,수량 정보 저장을 공백을 주고 입력하시오");
//			st = new StringTokenizer(br.readLine());
//			int num = Integer.parseInt(st.nextToken());
//			String name = st.nextToken();
//			int price = Integer.parseInt(st.nextToken());
//			int stock = Integer.parseInt(st.nextToken());
//			String info = st.nextToken();
		
// 			product = new Product(num,name,price,stock,info); //입력받은걸로 객체 생성
			pmgr.add(new Product(12345,"샘성라디오",55000,2,"고음질")); //  
			pmgr.add(new Refrigerator(23455,"삼성냉장고1",1800000,4,"큰타입",300,"blue"));
			pmgr.add(new Refrigerator(27755,"삼성냉장고3",870000,5,"가성비굿",250,"yellow"));
			pmgr.add(new Product(23125,"샘성에어컨",255000,1,"엄청시원")); 
			pmgr.add(new TV(7635,"삼성TV1번",1500000,7,"HD",24));
			pmgr.add(new Refrigerator(8876,"삼성냉장고2",1200000,2,"제일시원",400,"green"));
			pmgr.add(new TV(1236,"삼성TV2번",1200000,3,"HD",26));
			product = new Product(78543,"샘성선풍기",157000,5,"강풍지원"); 			
			pmgr.add(new TV(33333,"삼성TV3번",870000,7,"HD",22));
			 pmgr.add(product);
			
//			
//			test--;
//		}
		
		
		
		
		System.out.println("**********리스트 출력 ***********");
		pmgr.list();
//		System.out.println("검색할 상품 번호를 입력하세요");
//		int num2= Integer.parseInt(br.readLine());
		
		System.out.println("**********12345 검색 대상 출력***********");
		pmgr.list(1236);
		
//		System.out.println("삭제할 번호를 입력하세요");
//		num2 = Integer.parseInt(br.readLine());
		System.out.println("**********12345 삭제 후 출력 ***********");
		pmgr.delete(12345);
		
		System.out.println("1200000원까지 출력");
//		num2 = Integer.parseInt(br.readLine());
		System.out.println("**********특정 가격 이하 리스트 출력 ***********");
		pmgr.priceList(1200000);

		
		System.out.println("****************************");
		System.out.println("TV정보만 검색");
		
		Product[] products = pmgr.getTVinfo();
		
		for(Product p1 : products)
			System.out.println(p1);
	
		System.out.println("****************************");
		System.out.println("냉장고 정보만 검색");

		products = pmgr.getRefrigeratorinfo();
		for(Product p1 : products)
			System.out.println(p1);
		System.out.println("****************************");
		System.out.println("상품명으로 삼품을 검색(상품명에 냉장고 들어간거 검색)");
		
		products = pmgr.list("냉장고");
		for(Product p1 : products)
			System.out.println(p1);
		
		System.out.println("****************************");
		System.out.println("전체 재고 상품 금액 구하기(재고수량 곱해야함)");
		
		int sum = pmgr.getTotalPrice();
		System.out.println("전체 재고 상품 금액 : "+sum);
		
	}

}
