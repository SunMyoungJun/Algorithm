import java.util.ArrayList;
import java.util.HashSet;

public class Main {
	static int rowSize,colSize,answer;
	static int[] temp;
	static ArrayList<String> arr1 = new ArrayList<>();
	static String[][] rel;
	public static void main(String[] args) {
		String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};

		System.out.println(solution(relation));
		
		
	}
	
	public static int solution(String[][] relation) {
        answer = 0;
        
        rowSize = relation.length;
        colSize = relation[0].length;
        rel = relation;
        
        
        for(int i=1; i<colSize+1; i++) { // 컬럼 갯수 증가시키면서 보기
        	temp = new int[i];	
        	dfs(0,0,i);
        	
        	
        }
        
        
        
        return answer;
    }
	
	static void check(int N) {
		HashSet<String> set = new HashSet<>();
		StringBuilder sb = null;
		for(int i=0; i<rowSize; i++) {
			sb = new StringBuilder();
			for(int j=0; j<N; j++) {
				 sb.append(rel[i][temp[j]]).append(" ");
			}
			if(set.contains(sb.toString())) {
				return;
			}
			else {
				set.add(sb.toString());
			}
		}
		
		sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			sb.append(temp[i]);
		}
		
		int arr1Size = arr1.size();
		
		for(int i=0; i<arr1Size; i++) {
			String s1 = sb.toString();
			String s2 = arr1.get(i);
			
			int s1Size = s1.length();
			int s2Size = s2.length();
			
			int cnt=0,idx=0;
			for(int j=0; j<s1Size; j++) {
				if(s2.charAt(idx) == s1.charAt(j)) {
					idx++;
					if(idx == s2Size) {
						return;
					}
				}
			}
			

		}
		
		answer++;
		arr1.add(sb.toString());
	}
	
	
	static void dfs(int cnt,int idx, int N) {
		if(cnt == N) {
			check(N);
			return;
		}
	
		for(int i=idx; i<colSize; i++) {
			temp[cnt] = i;
			dfs(cnt+1,i+1,N);
		}
		
		
		
		
	}
	
	
}
