package lab.ssafy.corona.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

import lab.ssafy.corona.virus.Corona;
import lab.ssafy.corona.virus.Virus;

public class CoronaTest {

	public static void main(String[] args) {

		
//		Corona corona = new Corona();
//		corona.setName("코로나");
//		corona.setLevel(8);
//		corona.setSpreadSpeed(200);
//		Corona corona = new Corona("Corona",8,200);
//		
//		corona.showinfo();
	
//		Virus virus = new Virus("UNKNOWN",5);
//		System.out.println(virus);
	
//		Corona corona = new Corona("Covid19",5,20);ㅋ
//		System.out.println(corona);
	
		Virus virus = new Corona("Covid19",5,20);  //오버라이딩된 자식 클래스의 toString이 호출됨.
		System.out.println(virus);		// 자식에서 정의된 toString 메소드가 왜 부모인 virus 변수에서 접근할 수있을까?
//		virus.showInfo();               //이것도 자식 클래스의 메소드를 부모 변수가 사용하는건데 얘는 왜 오류일까?
										// => 왼쪽(부모클래스)에 toString이 있기때문에 자식의 toString으로 접근가능.
		
		//////////////////////////////////////////
		Corona c1 = new Corona("Corona5", 5, 5);
		Corona c2 = new Corona("Corona7", 5, 7);
		Corona c3 = new Corona("Corona3", 5, 3);
		Corona c4 = new Corona("Corona9", 5, 9);
		Corona c5 = new Corona("Corona1", 5, 1);
		Corona c6 = new Corona("Corona4", 5, 4);
		Corona c7 = new Corona("Corona10", 5, 10);
		
		PriorityQueue<Corona> pq = new PriorityQueue<>();
		pq.add(c1);
		pq.add(c2);
		pq.add(c3);
		pq.add(c4);
		pq.add(c5);
		pq.add(c6);
		pq.add(c7);
		
		while(!pq.isEmpty())
			System.out.println(pq.poll());
	/////////////////////////////////////////////////////	
		
		
		Virus fv1 = new Virus("fv1", 5);
		Virus fv2 = new Virus("fv2", 9);
		Virus fv3 = new Virus("fv3", 1);
		Virus fv4 = new Virus("fv4", 7);
		Virus fv5 = new Virus("fv5", 3);
		
		List<Virus> list2 = new ArrayList<>();
		list2.add(fv1);
		list2.add(fv2);
		list2.add(fv3);
		list2.add(fv4);
		list2.add(fv5);
		
		Collections.sort(list2, (o1,o2) -> {
			return o1.getLevel() - o2.getLevel();
		});
		
		for( Virus fv : list2) System.out.println(fv);
	}

}
