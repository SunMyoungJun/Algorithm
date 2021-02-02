import java.util.Scanner;

public class Solution1 {

	public static void main(String[] args) {

//		팩토리얼 구하기
		Scanner sc = new Scanner(System.in);
//		재귀(dfs)하면서 변화되는 값을 매개변수로 사용한다.
//		bfs -> 변화되는 값을 객체의 멤버변수로 사용한다.
		int num = sc.nextInt();
		int res = fact(num);
		System.out.println(res);
	}
	
	static int fact(int num) {
//		종료조건
		if(num ==1 || num==0) {   //0! 입력 들어오면 ? 수학적으로 0! =1 이기때문
			return 1;
		}
//		유도파트(실행문) &재귀호춣   /// 		//무조건 실행문(선택조건임)
		return num * fact(num-1);

	}
	
}
