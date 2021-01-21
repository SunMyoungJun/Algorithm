import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

///////////////////////////////제발 라스트
public class Main{
	static ArrayList<Integer> nodearr;
	static int count;
	
	public static void compare()
	{
		count++;     //들어오면서 일단 한개의 정점이 추가된거임 + 들어온 노드의 인덱스 번호도 된다 .
		int index = count;  //인덱스 저장
		int cut;   //2로나눠서 왼쪽자식인지 오른쪽 자식인지 보자.
		int temp=0;
		
		while(true)
		{
			cut = index/2;
			if(nodearr.get(cut) > nodearr.get(index))   //부모 정점보다 값 작으면 바꾸기
			{
				temp = nodearr.get(cut);
				nodearr.set(cut,nodearr.get(index));
				nodearr.set(index, temp);
				index = cut;  //바뀐 자리 인덱스 저장
			}
			else   //부모보다 크면 탈출
				break; 
		}
	}
	
	
	public static void remove()
	{
		System.out.println(nodearr.get(1));   //부모 노드(제일작은 값 출력 후 삭제)
		nodearr.set(1, nodearr.get(count)); //말단 노드 넣음.
		nodearr.remove(count);
		count--;   //트리에 남은 개수 
		int max_index = count;
		int where =1,temp =0; ////////////
		boolean bf = false;
		while(true)
		{
			bf = false; //////////////////////////////설마 이거때매? 
			if(max_index >=where*2 && max_index >=where*2+1)
			{
				if(nodearr.get(where*2) >= nodearr.get(where*2+1))
					bf = true;
			}
				
			
			if(where >=max_index)
				break;
			
			
			
			
			
			else if( (max_index >= where*2) && nodearr.get(where) > nodearr.get(where *2) && bf ==false)   //왼쪽 자식 
			{
				temp = nodearr.get(where);
				nodearr.set(where, nodearr.get(where*2));
				nodearr.set(where*2, temp);
				where = where *2;
			}

			else if((max_index >= where*2+1) && nodearr.get(where) > nodearr.get(where*2+1) && bf == true )  //오른쪽 자식
			{
				temp = nodearr.get(where);
				nodearr.set(where, nodearr.get(where*2+1));
				nodearr.set(where*2+1, temp);
				where = where*2+1;

			}
			else
				break;


		}
		
		
	}
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		count =0;
		
		nodearr = new ArrayList<>();
		nodearr.add(0);
		while(test !=0)
		{
			int num = Integer.parseInt(br.readLine());
			
			if(num ==0 && nodearr.size() ==1)  //입력 0인데 트리에 값이 없을 때
				System.out.println("0");
			else if(num ==0 && nodearr.size() != 1)   //입력 0 인데 트리에 값이 있을떄 
			{
				remove();
			}
			
			else // 그냥 들어와서 add 하면 될 때 
			{
				if(count ==0)   //트리에 값이 아무것도 없을 때 root에 넣기
				{	
					nodearr.add(num);
					count++;
				}
				else  //트리에 값이 있을 때 
				{
					nodearr.add(num);
					compare();
				}
					
			}
			
			test--;
		}

	}

}