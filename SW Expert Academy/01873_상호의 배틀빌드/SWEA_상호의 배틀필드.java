import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int H=0,W=0;
		String HW,userin;
		char[][] arr1;
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		int test = Integer.parseInt(br.readLine());
		int row =0,col=0;
		char direct = '0';
		int length=0;
		for(int t=1; t<test+1;t++)
		{
			row=0;
			col=0;
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken()); //행
			W = Integer.parseInt(st.nextToken()); //열

			arr1 = new char[H][W];
			for(int i=0;i<H;i++)
			{
				HW = br.readLine();
				for(int j=0;j<W;j++)
				{
					arr1[i][j] = HW.charAt(j);
					if(HW.charAt(j) == '>' ||HW.charAt(j) == '<' ||HW.charAt(j) == '^' ||HW.charAt(j) == 'v')
					{
						row = i;
						col = j;
						direct = HW.charAt(j);
					}
				}
			}


			length = Integer.parseInt(br.readLine());  //사용자입력길이
			userin = br.readLine();      //사용자입력문자

			for(int i=0;i<length;i++) {
				switch(userin.charAt(i)) {
				case 'U':
					direct = '^';
					arr1[row][col] ='^';
					if(row+dx[0]>=0 && arr1[row+dx[0]][col+dy[0]] =='.')
					{
						arr1[row][col] = '.';
						arr1[row+dx[0]][col+dy[0]] = '^';
						row = row-1;
					}
					break;
				case 'R':
					direct = '>';
					arr1[row][col] ='>';
					if(col+dy[1] <W && arr1[row+dx[1]][col+dy[1]] =='.')
					{
						arr1[row][col] = '.';
						arr1[row+dx[1]][col+dy[1]] = '>';
						col = col+1;	
					}	
					break;
				case 'D':
					direct = 'v';
					arr1[row][col] ='v';
					if(row+dx[2] <H && arr1[row+dx[2]][col+dy[2]] =='.')
					{
						arr1[row][col] = '.';
						arr1[row+dx[2]][col+dy[2]] = 'v';
						row = row+1;
					}
						
					break;
				case 'L':
					direct = '<';
					arr1[row][col] ='<';
					if(col+dy[3] >=0 && arr1[row+dx[3]][col+dy[3]] =='.')
					{
						arr1[row][col] = '.';
						arr1[row+dx[3]][col+dy[3]] = '<';
						col = col-1;
					}	
					break;

				case 'S':
					int temprow=row,tempcol=col;
					switch(direct) {
					case '^' :
						while(true)
						{
							if(temprow ==0)
								break;
							if(temprow+dx[0]>=0 && arr1[temprow+dx[0]][tempcol+dy[0]] =='#')
								break;
							if(temprow+dx[0]>=0 && arr1[temprow+dx[0]][tempcol+dy[0]] =='*')
							{
								arr1[temprow+dx[0]][tempcol+dy[0]] ='.';
								break;
							}
							temprow--;
						}
						break;
					case '>' :
						while(true)
						{
							if(tempcol == W-1)
								break;
							if(tempcol+dy[1] <W && arr1[temprow+dx[1]][tempcol+dy[1]] =='#')
								break;
							if(tempcol+dy[1] <W && arr1[temprow+dx[1]][tempcol+dy[1]] =='*')
							{
								arr1[temprow+dx[1]][tempcol+dy[1]] ='.';
								break;
							}
							tempcol++;
						}
						break;
					case 'v' :
						while(true)
						{
							if(temprow ==H-1)
								break;
							if(temprow+dx[2] <H && arr1[temprow+dx[2]][tempcol+dy[2]] =='#')
								break;
							if(temprow+dx[2] <H && arr1[temprow+dx[2]][tempcol+dy[2]] =='*')
							{
								arr1[temprow+dx[2]][tempcol+dy[2]] ='.';
								break;
							}
							temprow++;
						}	
						break;
					case '<' :
						while(true)
						{
							if(tempcol ==0)
								break;
							if(tempcol+dy[3] >=0 && arr1[temprow+dx[3]][tempcol+dy[3]] =='#')
								break;
							if(tempcol+dy[3] >=0 && arr1[temprow+dx[3]][tempcol+dy[3]] =='*')
							{
								arr1[temprow+dx[3]][tempcol+dy[3]] ='.';
								break;
							}
							tempcol--;
						}
						break;
					}
					break;

		
			}
		}
		System.out.print("#"+t+" ");
		for(int i=0;i<H;i++)
		{
			for(int j=0;j<W;j++)
			{
				System.out.print(arr1[i][j]);
			}
			System.out.println();
		}
		//바뀐 지형 출력.
	}

}

}
