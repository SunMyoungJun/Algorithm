package day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LamdaComparatorTest3 {

	public static void main(String[] args) {
		List<Data> list = new ArrayList<Data>();
		list.add(new Data(3,5,10));
		list.add(new Data(30,5,20));
		list.add(new Data(31,5,10));
		list.add(new Data(40,5,40));
		list.add(new Data(22,5,30));
		
//		Collections.sort(list,new Comparator<Data>() {
//			
//			@Override
//			public int compare(Data o1,Data o2) {
//				return o1.cnt - o2.cnt;
//			}
//		});
		
//		Collections.sort(list,(Data o1,Data o2) -> {
//			return o1.cnt - o2.cnt;
//		});
		
//		Collections.sort(list,(o1,o2) -> o1.cnt - o2.cnt); // cnt만 보고  오름차순 정렬..
		Collections.sort(list,(o1,o2) -> o1.cnt == o2.cnt ? o2.x - o1.x : o1.cnt-o2.cnt); // cnt같을때 x값기준 내림차순 정렬 

		for(Data d : list) {
			System.out.println(d);
		}
		
	}

}
