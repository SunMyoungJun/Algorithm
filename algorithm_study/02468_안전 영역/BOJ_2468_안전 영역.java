import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main{
static int[][] arr1;
static boolean[][] check;
static ArrayList<Integer> safecount = new ArrayList<>();
static int count=0;
static int[] dx = {-1,0,1,0 };
static int[] dy = {0,1,0,-1};
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int rowcol = Integer.parseInt(br.readLine());
		arr1 = new int[rowcol+2][rowcol+2];
		check = new boolean[rowcol+2][rowcol+2];
		int max=Integer.MIN_VALUE;
		for(int i=1;i<rowcol+1;i++)     // 입력값 배열에 채움.
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<rowcol+1;j++)
			{
				arr1[i][j] = Integer.parseInt(st.nextToken());
				if(arr1[i][j] >= max)
					max = arr1[i][j];
			}
				
		}
			
		for(int t=1;t<=100;t++)
		{
			if(t>=max)         //어짜피 높이 이하라서 멈춤.
				break;
			for(int i=1;i<rowcol+1;i++)
			{
				for(int j=1;j<rowcol+1;j++)
				{
					if(arr1[i][j] > t && check[i][j] ==false)
					{
						h_func(i,j,t);
						count++;
					}
						
				}
			}
			safecount.add(count);
			for(int i=1;i<rowcol+1;i++)
				for(int j=1;j<rowcol+1;j++)
					check[i][j] = false;
			count=0;     //다음 높이 이하 볼꺼니까 다시 0
		}
		if(safecount.isEmpty() ==false)
		{
			Collections.sort(safecount);
			System.out.println(safecount.get(safecount.size()-1));	
		}
		else
			System.out.println("1");
	}
/////////////////////////////////////////////////////메인
	
	static void h_func(int row,int col,int height) {
		check[row][col] = true;
		
		for(int i=0;i<4;i++)
		{
			int roww = row +dx[i];
			int coll = col +dy[i];
			if(arr1[roww][coll] >height && check[roww][coll] ==false)
				h_func(roww , coll , height);
		}
	}

}
