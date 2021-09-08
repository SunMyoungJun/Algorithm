import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int[][] arr1= new int[N-M+1][2];
		int[] number = {10,5,9,8,3,2,7,6,1,4,0};  //각 index숫자별 우선순위를 1~10까지 지정. number[10]은 2자리 수가 아닐때 가장 우선순위 낮은 0을 넣어둠.
		
		int size = N-M+1;  //입력 사이즈
		int idx=0;  //시작 인덱스
		StringBuilder sb = new StringBuilder();  //출력시 사용할 스트링빌더
		for(int i=M;i<=N;i++){
			if(i/10 ==0) {  //한자리 수 일때
				arr1[idx][0] = i%10;  //입력 값을 0번째인덱스에 넣음.
				arr1[idx][1] = 10;    // 2자리가 아니므로 가장 우선순위가 높은 10(number[10] =0)을 넣어둠.
			}
			else { //입력 2자리일 때
				arr1[idx][0] = i/10; //첫번째 자리수 0번에 저장
				arr1[idx][1] = i%10; // 일의 자리 수 1번에 저장
			}
			idx++;
		}
		
		Arrays.sort(arr1,new Comparator<int[]>() { //사전 순 검색을 위한 정렬 
			@Override
			public int compare(int[] o1, int[] o2) {
				if(number[o1[0]] == number[o2[0]]) {  //첫번째자리가 같을 때는 2번째 자리 까지 비교
					return (number[o1[1]] > number[o2[1]]) ? 1: -1; //2번째 자리 수가 낮은거 부터 나열
				}
				return (number[o1[0]] > number[o2[0]]) ? 1:-1;  //첫번째 자리가 다를 때 첫번째 자리 수가 낮은거 부터 나열
			}
		});
				
		int cnt =1;
		for(int i=0;i<size;i++) {  //총 숫자 갯수 만큼
			if(cnt %10 ==0) {  //10개마다 줄바꿈 출력을 위한 cnt 
				if(arr1[i][1] ==10) {
					sb.append(arr1[i][0]).append("\n");  //한자리 수 일때
				}
				else {
					sb.append(arr1[i][0]).append(arr1[i][1]).append("\n"); // 두자리 수 일때
				}
			}
			else {  
				if(arr1[i][1] ==10) {   
					sb.append(arr1[i][0]).append(" "); // 한자리 수 일 떄
				}
				else {  
					sb.append(arr1[i][0]).append(arr1[i][1]).append(" "); // 두 자리 수 일 떄
				}
			}
			cnt++; //10개마다 줄바꿈 출력을 위한 cnt 증가
		}
		System.out.println(sb.toString());  //정답 출력
	}
}