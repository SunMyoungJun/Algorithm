package sjava;

public class ForTest {

	public static void main(String[] args) {
		//별 찍기
//		*
//		**
//		***
//		****
//		*****
		
		String res ="*";
	/*	for(int i=0;i <5; i++) {
			System.out.println(res);
			res +="*";
		}
		
	 */		
		
		
	/*	for(int i=0; i<100000; i++) { //이게 더 속도느림
			//i가 계속 100000과의 조건을 비교해야하는데 높은수를 계속 비교해야해서 쫌더복잡
			System.out.println("*");
		}
		
		for(int i=100000; i>0; i--) { //이게 더 속도 빠흠
			System.out.println("*");
		} */
		
		for(int i=0;i<5;i++) {
			for(int j=0;j<=i;j++){ //웬만하면 <=i보단 <i+1 로쓰자
				//<=i : <1번 ,=1번 ->2번 이고 <i+1 : i,i+1 2번으로 비교횟수는 똑같지만 
					//비교연산자가 더 복잡해서? 오래걸림 ...
				System.out.print(res);
			}
			System.out.println();
		}
			
	 int cnt=1;
		for(int i=0;i<5;i++) {
			for(int j=0;j<cnt;j++) {
				System.out.print("*");
			}
			cnt++;
			System.out.println();
		}
		
		
		//java는 goto,const 못씀
		
		//aaa,bbb label 주면 브레이크로 goto처럼쓸수잇음
	/*	aaa:for(int i=0;i<5;i++) {
			System.out.println(i+" ");
			bbb:for(int j=0;j<i+1;j++) {
				if(i ==2) {
					break aaa;
				}
				System.out.print("*");
			}
		
			System.out.println();
		}
		
		*/
	}

}
