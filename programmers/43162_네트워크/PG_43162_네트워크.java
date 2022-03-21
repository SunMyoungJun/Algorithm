class Solution {
    int N;
    boolean[] check;
    int[][] computer;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        N=n;
        check = new boolean[N];
        computer = computers;
        for(int i=0; i<N;i++) {
            if(check[i] == false) {
                answer++;
                check[i] = true;
                dfs(i);
            }
        }   
        return answer;
    }
    
    void dfs(int idx) {
        for(int i=0; i<N; i++) {
            if(idx ==i){
                continue;
            }
            if(computer[idx][i] == 1 && check[i] == false) {
                check[i] = true;
                dfs(i);
            }
        }
    }
}