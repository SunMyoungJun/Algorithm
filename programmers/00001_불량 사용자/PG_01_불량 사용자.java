

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PG_1 {

	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;
		String temp;
		String[] toByto;
		Map<String,Integer> map = new HashMap<>();
		Map<String,Integer> map2 = new HashMap<>();
		int id_len = id_list.length;
		ArrayList<String>[] arr1 = new ArrayList[id_len];
		int[] answer = new int[id_len];
		boolean[][] check = new boolean[id_len][id_len];
		
		int report_len = report.length;
		int cnt=0,idx1=0,idx2=0;
		for(int i=0; i<id_len; i++) {
			map.put(id_list[i],i);
			arr1[i] = new ArrayList<String>();
		}
		cnt=0;
		for(int i=0; i<report_len; i++) {
			toByto = report[i].split(" ");
			idx1 = map.get(toByto[0]);
			idx2 = map.get(toByto[1]);
			
			if(check[idx1][idx2] == true) {
				continue;
			}
			arr1[idx1].add(toByto[1]);
			check[idx1][idx2] = true;
			
			if(map2.get(toByto[1]) == null) {
				map2.put(toByto[1], 1);
			}
			else {
				map2.put(toByto[1], map2.get(toByto[1])+1);
			}	
		}
		
		
		for(int i=0; i<id_len; i++) {
			int size = arr1[i].size();
			int cnt2 =0;
			for(int j=0; j<size; j++) {
				temp = arr1[i].get(j);
				
				if(map2.get(temp) == null) {
					continue;
				}
				
				if(map2.get(temp) >= k) {
					cnt2++;
				}
			}
			answer[cnt++] = cnt2;
		}
		
		for(int i=0; i<id_len; i++) {
			System.out.println(answer[i]);
		}
		
		
		
	}

}
