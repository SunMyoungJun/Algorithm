import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		int[] row = new int[4];
		int[] col = new int[4];
		
		
		for(int t=0; t<4; t++) {   
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<4;i++) {
				col[i] = Integer.parseInt(st.nextToken()); 
				row[i] = Integer.parseInt(st.nextToken());
			}
			
			//col[0] 1번째 열 시작 // col[1] 1번째 열 끝 // col[2]  2번째 열 시작  // col[3] 2번째 열 끝 
			//row[0] 1번째 행 시작 // row[1] 1번째 행 끝 // row[2]  2번째 행 시작 // row[3] 2번째 행 끝
			if((row[1]<row[2] || row[3] < row[0]) || (col[1] < col[2] || col[3] < col[0])) { //아예 안겹칠때 
				System.out.println("d");
			}
			else if((row[0] == row[3] || row[2] == row[1]) && (col[1] == col[2] || col[0] == col[3])) {  //한점이 겹칠때
				System.out.println("c");
			}
			else if(col[1] ==col[2] || row[1] == row[2] || col[0] == col[3] || row[0] ==row[3] ) {  //선분 겹칠때
				System.out.println("b");
			}
			else {
				System.out.println("a");
			}
		}
	
	}

}
