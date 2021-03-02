import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt=0,size=0;
		int S = sc.nextInt();
		boolean[][] check = new boolean[S*2+1][S*2+1];
		
		Queue<int[]> q1 = new LinkedList<int[]>();
		int[] temp;
		q1.offer(new int[] {1,0});   //현재 화면 이모티콘 갯수 , 클립보드복사본 갯수
		while(!q1.isEmpty()) {
			size = q1.size();
			
			
			for(int i=0;i<size;i++) {
				temp = q1.poll();
				
				if(temp[0] == S) {
					System.out.println(cnt);
					return;
				}
				
				else if(temp[0] <S) { 
					if(check[temp[0]][temp[0]] == false) {
						q1.offer(new int[] {temp[0],temp[0]}); //복사하기 복사는 무조건 두개 같은값 들어가므로 이때만 체크써서 걸러줌.
						check[temp[0]][temp[0]]= true;
					}
					if(check[temp[0]+temp[1]][temp[1]] == false) {
						q1.offer(new int[] {temp[0]+temp[1],temp[1]});  //붙혀 넣기
						check[temp[0]+temp[1]][temp[1]] = true;
					}
				}
				
				if(temp[0]-1 >0 && check[temp[0]-1][temp[1]] == false) {
					q1.offer(new int[] {temp[0]-1,temp[1]}); //숫자 클떄는 빼기만 큐에 들어감.
					 check[temp[0]-1][temp[1]] = true;
				}
			}
			
			cnt++;	
		}	
	}
}