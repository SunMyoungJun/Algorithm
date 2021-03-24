import java.util.Arrays;

public class DisjointSetTest {  //유니온 파인드(경로 압축 포함) (랭크관리는 안함)
	
	static int N;
	static int parents[];
	
	static void make() { // 크기가 1인 단위집합을 만든다(처음 원소들은 모두 자기 자신이 대장임).
		for(int i=0;i<N;i++) { 
			parents[i] = i;
		}
	}
	
	static int findSet(int a) {  //리턴값 있는 이유 : 찾은 대장 값을 리턴하면서 전부 대장 값으로 대입하면서 경로 압축 됨.
		if(parents[a] ==a)  //내가 대장일 때 
			return a;
		
//		return parents[a] = findSet(parents[a]);   //path compression 한거  // 밑에 세줄 이거 한줄로
		int temp = findSet(parents[a]);
		parents[a] = temp;
		return temp;
	}
	
	
	static boolean union(int a,int b) {  //a,b가 합쳐지면 true, 대장을 찾았더니 같은 집합이엿다면 false
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) { //두 집합이 같은 집합일 때
			return false;
		}
		
		parents[bRoot] = aRoot;
		return true;       // boolean타입으로 true냐 false판단하는 이유는 나중에 응용문제에서 사용될 수있어서 그럼.
		
	}
	
	
	
	public static void main(String[] args) {
		N =5;
		
		parents = new int[N];
		
//		1.make set
		make();   // 각자 원소들을의 집합을 자기 자신으로 만듬
		
		System.out.println("==============union==============");

		System.out.println(union(0,1));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(1,2));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(3,4));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(0,2));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(0,4));  //이거 하면 4의 부모인 3번째 인덱스가 0으로 바뀜. 4번쨰인덱스는 3을 가르킴.
										 // 따라서 0 0 0 0 3 인데 앞에 0끼리 같은 집단, 뒤의 3이 다른 집단이다 라고 판단 하면안됨.
										 //findSet을 통해서 같은 집단인지 판단해야함.
										 //findSet(4)를 하면 경로 압축에 의해 4번째 인덱스가 0으로 바뀌게됨.
		System.out.println(Arrays.toString(parents));
		
		System.out.println("==============find===============");
		
		System.out.println(findSet(4));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(3));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(2));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(0));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(1));
		System.out.println(Arrays.toString(parents));
		
		
		
	}

}
