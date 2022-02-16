import java.util.ArrayList;
class Solution { 
	ArrayList<Integer>[] arr1;
	boolean[][][] check;
	int max=0;
	int solution(int[] info, int[][] edges) {
		int infoSize = info.length;
		int edgesSize = edges.length;
		arr1 = new ArrayList[infoSize];
		
		check = new boolean[infoSize][20][20];
		
		for(int i=0; i<infoSize; i++) {
			arr1[i] = new ArrayList<>();
		}
		
		for(int i=0; i<edgesSize; i++) {
			arr1[edges[i][0]].add(edges[i][1]);
			arr1[edges[i][1]].add(edges[i][0]);
		}
		dfs(0,0,0,info);
		return max;
	}
    void dfs(int idx,int sheep,int wolf,int[] info) {
		int temp = info[idx];
		
		
		if(info[idx] == 0) {
			sheep++;
		}
		else if(info[idx] == 1) {
			wolf++;
		}
		if(wolf >= sheep) {
			return;
		}
		
		max = (max > sheep) ? max : sheep;
		
		if(check[idx][sheep][wolf] == true) {
			return;
		}
		
		check[idx][sheep][wolf] = true;
		info[idx] = -1;
		int size = arr1[idx].size();
		for(int i=0; i<size; i++) {
			dfs(arr1[idx].get(i),sheep,wolf,info);
		}
		
		info[idx] = temp;
		check[idx][sheep][wolf] = false;
		
		
		
	}
	
}
