package sjava;

public class IfTest {
public static void main(String[] args) {
	int num = 10;
	if(num > 5) System.out.println(); //한줄 가능하지만 권장하지 않음.

	if(num >5 && num >9) {
		System.out.println("실행");
	}
	
	String s = null;
//	String s ="asd";
//	if(s.length() > 5 && s !=null) { //오류뜸 null인 String에 .을 써서 그럼
//		System.out.println("문자열이 5보다 큽니다.");
//	}
	
	if( s !=null && s.length() > 5) { //이거는 오류안뜸. 앞에서 이미 널을 판단해서 뒤에 s. 조건까지 안가므로
		System.out.println("문자열이 5보다 큽니다.");
	}

	
	
	
	
	
	
}
}
