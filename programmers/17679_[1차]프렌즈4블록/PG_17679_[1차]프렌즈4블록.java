class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        boolean[][] check;
        
        char[][] boards = new char[m][n];
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                boards[i][j] = board[i].charAt(j);
            }
        }
        
        
        
        while(true) {
            boolean stop=false;
            check = new boolean[m][n];
            boolean flag3=false;
            for(int i=0; i<m-1; i++) {
                char a,b,c,d;
                flag3=false;
                for(int j=0; j<n-1; j++) {
                    a = boards[i][j];
                    b = boards[i][j+1];
                    c = boards[i+1][j];
                    d = boards[i+1][j+1];
                    
            
                    if(a ==b && a==c && a==d) {
                        check[i][j] = true;
                        check[i][j+1] = true;
                        check[i+1][j] = true;
                        check[i+1][j+1] = true;
                    }
                } 
            }
            
            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {
                    if(boards[i][j] !=' ' && check[i][j] == true) {
                        boards[i][j] = ' ';
                           answer++;
                           stop = true;
                        
                      
                    }
                }
            }
            if(!stop) {
                break;
            }
            

            for(int i=0; i<n; i++) {
                boolean flag = false,flag2=false;
                int idx=0;
                for(int j=m-1; j>=0; j--) {
                    if(!flag && boards[j][i]==' ') {
                        flag = true;
                        idx = j;
                    }
                    else if(flag && boards[j][i]!=' ') {
                        flag2=true;
                    }
                    if(flag2 == true && boards[j][i]  !=' ') {
                        boards[idx][i] = boards[j][i];
                        idx--;
                        boards[j][i] = ' ';
                    }
                    else if(flag2 == true && boards[j][i]==' ') {
                        flag2=false;
                    }
                }
            }
        }
                
        return answer;
    }
}