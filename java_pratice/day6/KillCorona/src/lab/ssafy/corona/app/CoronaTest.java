package lab.ssafy.corona.app;

import lab.ssafy.corona.virus.Corona;

public class CoronaTest {

	public static void main(String[] args) {

		
//		Corona corona = new Corona();
//		corona.setName("코로나");
//		corona.setLevel(8);
//		corona.setSpreadSpeed(200);
		Corona corona = new Corona("Corona",8,200);
		
		corona.showinfo();
	}

}
