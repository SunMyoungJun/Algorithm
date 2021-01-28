package lab.ssafy.corona.app;

import lab.ssafy.com.medical.Hospital;
import lab.ssafy.com.medical.Organization;

public class AboutTest {
	
	public static void main(String[] args) {
		
		Organization org = new Hospital("대학병원", 15, "001", 50, 10);
		org.about();

	}

}