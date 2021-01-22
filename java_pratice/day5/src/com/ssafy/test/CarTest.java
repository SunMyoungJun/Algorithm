package com.ssafy.test;

public class CarTest {

	public static void main(String[] args) {

		Car car1 = new Car();
		Car car2 = new Car();
		Car car3 = new Car();

//		car1.serialNumber = 1;
//		car2.serialNumber = 2;
//		car3.serialNumber = 3;

		System.out.println(car1.getSerialNumber());
		System.out.println(car2.getSerialNumber());
		System.out.println(car3.getSerialNumber());

		
		Car carTemp = new Car();
		System.out.println(carTemp.getSerialNumber());
		System.out.println(Car.carLastNumber); //static 변수 보다는 클래스 변수라고 많이함. 이렇게 Car.num으로접근 보통해서
		System.out.println(Car.carLastNumber);
		System.out.println(Car.carLastNumber);
	
	}

}

class Car {
	 static int carLastNumber=0;  //new 전에 클래스영역에 생성시 생성되므로 클래스 변수라고함.
	private int serialNumber; //new 인스턴스화 하면서 생성되므로 인스턴스 변수라고 함.

	
	
	
	
	public Car() {
		carLastNumber++;                    /// num이 static 변수로 선언되서 car객체를 3개 생성해도 num은 공유함.
		serialNumber = carLastNumber;         // 따라서 시리얼넘버가 1,2,3  따로 들어감.
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	private void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}


	
	
}







