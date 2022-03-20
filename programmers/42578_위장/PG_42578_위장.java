import java.util.*;
class Solution {
    int[] arr1;
    int cnt,sum;
    public int solution(String[][] clothes) {
        int answer=0;
        String name,kind;
        HashMap<String,Integer> map = new HashMap<>();     
        int rsize = clothes.length;
        
        for(int i=0; i<rsize; i++) {
            kind = clothes[i][1];
            if(map.get(kind) == null) {
                map.put(kind,cnt);
                cnt++;
            }
        }
        arr1 = new int[cnt];
        
        for(int i=0; i<rsize; i++) {
            kind = clothes[i][1];
            arr1[map.get(kind)] +=1;
        }
        dfs(0,1);
        answer = sum-1;
        return answer;
    }
    
    void dfs(int idx,int summ) {
        if(idx == cnt) {
            sum += summ;
            return;
        }
        dfs(idx+1,summ*arr1[idx]); //선택한다
        dfs(idx+1,summ*1); // 선택안한다
    } 
}