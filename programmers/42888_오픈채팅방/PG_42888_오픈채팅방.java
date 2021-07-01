import java.util.*;
class Solution {   
    public String[] solution(String[] record) {
        StringBuilder sb = new StringBuilder();
        HashMap<String,String> map = new HashMap<String,String>();
        int record_len=record.length;
        int cnt=0,cnt2=0;
        String[][] result = new String[record_len][];
        for(int i=0; i<record_len; i++) {
            result[i] = record[i].split(" ");
            
            if(result[i][0].equals("Enter"))  {
               cnt++;
                map.put(result[i][1],result[i][2]);
            }
            else if(result[i][0].equals("Leave")) {
                cnt++;
            }
            else { // change일 때
                map.put(result[i][1],result[i][2]);
            }
        }
        
        String[] answer = new String[cnt];
        
        for(int i=0; i<record_len; i++) {
            if(result[i][0].equals("Enter")) {
                answer[cnt2++] = map.get(result[i][1])+"님이 들어왔습니다.";
            }
            else if(result[i][0].equals("Leave")) {
                answer[cnt2++] = map.get(result[i][1])+"님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}