class Solution {
    int size,count,result;
    int[] number;
    boolean[] check;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        result = target;
        number = numbers;
        size = number.length;
        check = new boolean[size];
        
        
        dfs(0,0);
        
        
        return count;
    }
    
    
    void dfs(int cnt,int sum) {
      if(cnt == size) {
          if(sum == result) {
            count++;  
          }
          return;
      }
        
        dfs(cnt+1,sum+number[cnt]);
        dfs(cnt+1,sum-number[cnt]);
            
        
    }
    
    
    
}