package com.ssafy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CollectionTest {

	public static void main(String[] args) {
		
		  //        List<String> list = new ArrayList<String>();

	    //        Set<String> list = new HashSet<>();
	    Set<String> list = new TreeSet<>();

	    list.add("ssafy");
	    list.add("java");
	    list.add("algo");
	    list.add("project");
	    list.add("algo");
	    for(String s : list) {
	        System.out.println(s);
	    }
	    
	    Set<Data> dList = new TreeSet<>();
	    dList.add(new Data(1));
	    dList.add(new Data(2));
	    dList.add(new Data(4));
	    dList.add(new Data(3));
	    System.out.println(dList.size());
	    for(Data d : dList) {
	        System.out.println(d.num);
	    }
	}

}

class Data implements Comparable<Data>{
    int num;
    Data(int num){
        this.num = num;
    }
    @Override
    public boolean equals(Object obj) {
        Data d = (Data)obj;
        return this.num == d.num;
    }
    @Override
    public int compareTo(Data o) {

        return o.num - this.num;  // 양수가 나오면 오름차순, 음수가 나오면 내림차순
    }

}
