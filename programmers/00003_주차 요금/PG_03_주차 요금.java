package algorithm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class PG_kakao_3 {

	public static void main(String[] args) {
		int[] fees = {180, 5000, 10, 600};
		String[] records = {"05:34 5961 IN", "06:00 0000 IN",
				"06:34 0000 OUT", "07:59 5961 OUT",
				"07:59 0148 IN", "18:59 0000 IN",
				"19:09 0148 OUT", "22:59 5961 IN",
				"23:00 5961 OUT"};
		
		Map<String,String> map = new HashMap<>();
		Map<String,Integer> idxmap = new TreeMap<>();
		int[] price = new int[10000];
		
		int records_len = records.length;
		for(int i=0; i<records_len; i++) {
			String[] gi = records[i].split(" ");
			if(map.get(gi[1]) == null) {
				map.put(gi[1], gi[0]);
			}
			else {
				String[] hourminute = map.get(gi[1]).split(":");
				String[] hourminute2 = gi[0].split(":");
				int hour = Integer.parseInt(hourminute2[0])
							- Integer.parseInt(hourminute[0]);
				int minute = Integer.parseInt(hourminute2[1])
							- Integer.parseInt(hourminute[1]);
				
				if(minute <0) {
					hour = hour -1;
					minute = 60 + minute;
				}
				int sum = hour * 60 + minute;
				
				int num = Integer.parseInt(gi[1]);
				
				if(idxmap.get(gi[1]) != null) {
					idxmap.put(gi[1], idxmap.get(gi[1]) + sum);
				}
				else {
					idxmap.put(gi[1], sum);
				}
				map.remove(gi[1]);
			}
		}
		
		Iterator<String> ir = map.keySet().iterator();
		
		while(ir.hasNext()) {
			String firstKey = ir.next();
			String[] hourminute = map.get(firstKey).split(":");
			int hour = 23 - Integer.parseInt(hourminute[0]);
			int minute = 59 - Integer.parseInt(hourminute[1]);
			int sum = hour * 60 + minute;

			if(idxmap.get(firstKey) != null) {
				idxmap.put(firstKey, idxmap.get(firstKey) + sum);
			}
			else {
				idxmap.put(firstKey, sum);
			}
		}
		
		Iterator<String> ir2 = idxmap.keySet().iterator();
		
		int idx1 = idxmap.size();
		int cnt=0;
		int[] answer = new int[idx1];
		while(ir2.hasNext()) {
			String firstKey = ir2.next();
			int price1 = idxmap.get(firstKey);
			if(price1 <= fees[0]) {
				price1 = fees[1];
			}
			else {
				int priceNum =0;
				if((price1 - fees[0]) % fees[2] !=0) {
					priceNum +=1;
				}
				priceNum += (price1 - fees[0]) /fees[2];
				price1 = fees[1] + priceNum*fees[3];
			}
			answer[cnt++] = price1;
		}
		
		for(int i=0; i<idx1; i++) {
			System.out.println(answer[i]);
		}
		
		
		
	}

}
