import java.util.*; 
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        HashMap<String,Integer> map1 = new HashMap<>();
        HashMap<String,Integer> map2 = new HashMap<>();
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        int size1 = str1.length();
        int size2 = str2.length();
        
        String temp1="";
        String temp2="";
        boolean flag = false;
        for(int i=0; i<size1-1; i++) {
            temp1 = str1.substring(i,i+2);
            flag = false;
            for(int j=0; j<2; j++) {
                if(!(temp1.charAt(j) >='a' && temp1.charAt(j) <='z')) {
                    flag =true;
                }
            }
            
            if(!flag) {
                if(map1.get(temp1) != null) {
                    map1.put(temp1,map1.get(temp1)+1);
                }
                else {
                    map1.put(temp1,1);
                }
            }       
        }
        
         for(int i=0; i<size2-1; i++) {
            temp2 = str2.substring(i,i+2);
            flag = false;
            for(int j=0; j<2; j++) {
                if(!(temp2.charAt(j) >='a' && temp2.charAt(j) <='z')) {
                    flag =true;
                }
            }
            
            if(!flag) {
                if(map2.get(temp2) != null) {
                    map2.put(temp2,map2.get(temp2)+1);
                }
                else {
                    map2.put(temp2,1);
                }
            }       
        }
        
        int Ncnt=0,Ucnt=0;
        
        for(String s1 : map1.keySet()) {
            if(map2.get(s1) == null) {
                Ucnt += map1.get(s1);
                continue;
            }
            Ucnt += Math.max(map1.get(s1),map2.get(s1));
            Ncnt += Math.min(map1.get(s1),map2.get(s1));
        }
        
        for(String s2 : map2.keySet()) {
            if(map1.get(s2) == null) {
                Ucnt += map2.get(s2);
            }
        }
        
        if(Ucnt !=0) {
            double result = (double)Ncnt / Ucnt * 65536;
            answer = (int)result; 
        }
        else {
            answer = 65536;
        }
        
        
        
        return answer;
    }
}