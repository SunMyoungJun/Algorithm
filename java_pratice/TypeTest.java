package sjava;

public class TypeTest {

	public static void main(String[] args) {
			int num = 200;
			boolean flag = true;
			char ch ='\u0041';
			System.out.println(ch);
			//char =2바이트로 표현할수있다.
			
			
			short s1 =3; 
			short s2 =4;
//			short s3 = s1+s2;//주석 풀면 오류임 이유 : 자바의 기본 연산의 최소 단위는 int라서!!
			short s3 = (short)(s1+s2); //이렇게 써야 오류안남.
			
			int i1 =3;
			int i2=4;
			boolean flagi2 = i1>4 && ++i2 >3;
			System.out.println(i2);   //4가 나오는 이유 : 앞에 조건에서 이미 거짓이라서 뒤에꺼 안봄
	
	
			String str ="hello";
			str = str+ "java"; //문자열은 str과 java의 덧셈에서 교환법칙 성립 x
			
			int num1 =3;
			int num2 =4;
			//max값 출력해라
			int max = (num1 > num2) ? num1 : num2; //삼항 연산자
			System.out.println(max);
	
			//num1 = num1 * 1024; //num1을 1024번 반복 실행
			//num1 = 1024 * num1; //1024를 num1번 반복 실행
	
			
			//쉬프트 연산자
			//num1 -> 00000011 비트로
			//num1 = num1 * 8; //8을 곱한다는거는 2^3이므로 3만큼 왼쪽으로 쉬프트한다.
			//00000011 -> 00011000
			//num1 = num1 <<3; //왼쪽으로 3 쉬프트
			// num1 *8 은 num1 을 8번 곱하므로 시간이 더 걸림
			//num1 = num1 <<3 은 같은 값이 나오지만 시간이 더 짧음.
			//그러나 2의 몇승으로 안나타나면 그냥 곱해야하는게 맞음.
			//num1 << = 35; 결과는 ? 
			//int는 4바이트,32비트이므로 35를 왼쪽으로 쉬프트하면 오버플로우가 뜰거같지만
			//자바 내부적으로 넘어가는걸 생각해서인진 모르겟지만
			//num1 < ==35%32 로 계산해서 왼쪽으로 3만큼 쉬프트함.
			
			System.out.println(num1);
	}	
}
