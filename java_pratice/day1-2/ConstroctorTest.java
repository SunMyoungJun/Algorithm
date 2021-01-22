package com.ssafy.classsam;

public class ConstroctorTest {

	public static void main(String[] args) {
//		java.lang.* 구문이 컴파일러에 의해 자동 주입된다. 그래서 System.out.print나 String 같은거 등등 사용가능한거임
		
		Data d1 = new Data(); // 생성자를 통해서 인스턴스 과정을 사용해서 인스턴스 객체가 만들어진다.
		Data d2 = new Data("이름");   
		Data d3 = new Data("이름",1234);
		d2.setName("ssss");
		System.out.println(d2.getName());
	
		Sam sam = new Sam();
		sam.setAge(30);
		System.out.println(sam.getAge());  //이렇게 메소드 통해 접근해야 제어가능. 만약 나이에 -30이면 밑에 메소드에서 조건줘서 해결가능.
	
	}

}





class Sam {
	String name; //필드 ,멤버변수
	private int age;
	public void setAge(int age) {
		this.age = age;
		
	}
	public int getAge() {
		return age; //보편적으로 this. 생략
	}
	
	
}







class Data{
	
	String name;  //멤버 변수 (필드)
	int age; // 인스턴스 변수
	
	
//	기본생성자가 컴파일러에 의해서 자동 주입된다.
	Data() { //여기 앞에 void 가 붙으면 생성자가 아니고 그냥 메소드이므로 출력안됨.
//		따라서 이렇게 쓰는것을 특수 메소드 라고함. 반환타입이 없고 클래스 이름과 철자가 같은 메소드 사용할 경우 new 키워드 다음에 사용
		System.out.println("생성자가 생성되는지 확인하는중");
	}
	Data(String name) { //생성자는 여러개 사용 가능.
		System.out.println("생성자가 생성되는지 확인하는중");
		this.name = name;
	}
	Data(String name, int age) { 
		//이런데 선언되면 지역변수.
		System.out.println("생성자가 생성되는지 확인하는중");
		this.name = name;
		this.age = age;
	}
	
	void setName(String name) {
		this.name = name;
	}
	String getName() {
		return this.name; //this 생략해도됨
	}
	
	
	
}