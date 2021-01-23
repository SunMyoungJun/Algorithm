import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr1 = new int[N+1];
		int[] arr2 = new int[N+1];
		ArrayList<Integer> robot = new ArrayList<Integer>();
		robot.add(0);
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<N+1;i++)
			arr1[i] = Integer.parseInt(st.nextToken());
		for(int i=N;i>0;i--)
			arr2[i] = Integer.parseInt(st.nextToken());


		int temp1 =0,temp2=0;  //1번 회전 시 필요
		int testcount=0,kcount=0;
		while(true)
		{
			testcount++;
			temp1 = arr2[1];                  //////1번과정
			temp2 = arr1[N];
			for(int i=N;i>1;i--)
				arr1[i] =arr1[i-1]; 
			for(int i=1;i<N;i++)
				arr2[i] = arr2[i+1];
			arr1[1] = temp1;
			arr2[N] = temp2;   

			if(robot.size() >1)  //벨트에 로봇이 있다면
			{
				for(int i=1;i<robot.size();i++)  //회전 시 로봇들도 1칸씩 전진
				{
					robot.set(i,robot.get(i)+1);           
					if(robot.get(i) == N) //내려가는 위치면 삭제
						robot.remove(i);
				}

				for(int i=robot.size()-1;i>0;i--)   //먼저들어온놈부터확인해서 칸남으면 전진.
				{
					if(arr1[robot.get(i)+1] >0 && (i==robot.size()-1 || robot.get(i)+1 <robot.get(i+1)))
					{
						robot.set(i,robot.get(i)+1);
						arr1[robot.get(i)]--;
						if(arr1[robot.get(i)] ==0)
							kcount++;
						if(robot.get(i) == N)
							robot.remove(i);
					}
				}

			}				

			if(robot.size() ==1 && arr1[1] >0)
			{
				robot.add(1,1);
				arr1[1]--;
				if(arr1[1] == 0)
					kcount++;
			}

			if(robot.size() >1 && robot.get(1) !=1)     // 시작위치에서 가장 가까운 로봇의 x위치가 0이아니면 삽입
			{
				if(arr1[1] >0) {
					robot.add(1,1);
					arr1[1]--;
 					if(arr1[1] ==0)
						kcount++;
				}
			}
			if(kcount >= K)
				break;
		}
		System.out.println(testcount);

	}
}
