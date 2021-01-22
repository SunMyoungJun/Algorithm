package com.ssafy.hw5;

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
		while(test !=0)   //키보드로 입력받기 ...
		{
			System.out.println("상품번호, 삼품이름,가격,수량 정보 저장을 공백을 주고 입력하시오");
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			int price = Integer.parseInt(st.nextToken());
			int stock = Integer.parseInt(st.nextToken());
			String info = st.nextToken();
			
			
			 product = new Product(num,name,price,stock,info); //입력받은걸로 객체 생성
			
			pmgr.add(product);
			
			
			
			
			test--;
		}
		System.out.println("**********리스트 출력 ***********");
		pmgr.list();
		System.out.println("검색할 상품 번호를 입력하세요");
		int num2= Integer.parseInt(br.readLine());
		
		System.out.println("**********검색 대상 출력***********");
		pmgr.list(num2);
		
		System.out.println("삭제할 번호를 입력하세요");
		num2 = Integer.parseInt(br.readLine());
		System.out.println("**********삭제 후 출력 ***********");
		pmgr.delete(num2);
		
		System.out.println("보실 가격까지 입력하세요");
		num2 = Integer.parseInt(br.readLine());
		System.out.println("**********특정 가격 이하 리스트 출력 ***********");
		pmgr.priceList(num2);
	
	}

}
