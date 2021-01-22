package com.ssafy.classsam;

import java.lang.String; //네이밍 기법.
import java.lang.*;      //그룹핑 기법. //어떤게 쓰일지모름. 충돌할수도 있음. // 따라서 네이밍기법 권장.
//import java.util.*;
//import java.awt.*;
import java.util.Scanner;
import java.awt.Button;
public class ImportTest {

	public static void main(String[] args) {
		//클래스의 fullname을 사용하세요
		//java.lang.String s;
		String s;
		//java.util.Scanner sc;
		Scanner sc;
		Button btn;
		
		//List list;   //이거 주석풀면 오류.   왜냐면 java.util.* 과 java.awt.*에 둘다 있어서 머갖다 쓸지몰라서 오류.
						//따라서 사용할 떄는 앵간하면 ctrl + shift + O 해서 사용하는 것만 import하는게 베스트.
	}

}
