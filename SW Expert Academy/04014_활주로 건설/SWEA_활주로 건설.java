import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static int N,X;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int test = Integer.parseInt(br.readLine());
        for(int t=1; t<test+1; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            map = new int[N][N];
 
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int cnt2 = verti();
            int cnt1 = horizen();
             
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ").append(cnt1+cnt2);
            System.out.println(sb.toString());
        }
    }
    static int verti() {
        int cnt = 0,gung =0,samecnt=0,samenum=0,temp=0,aftercnt=0;
        int result =0;
        boolean tf = false;
        for(int j=0;j<N;j++) {
            tf = false;
            cnt =  gung = 0;
            samecnt =1; samenum = map[0][j];
            for(int i=1;i<N;i++) {
                temp = samenum - map[i][j];
                if(temp >1 || temp <-1) {
                    tf = true;
                    break;
                }
                else if(temp == -1) {
                    samenum = map[i][j];
                    if(samecnt >=X) { // 전에 경사로 설치가능?
                        samenum = map[i][j];
                        samecnt = 1;
                    }
                    else {
                        tf = true;
                        break;
                    }
                }
                else if (temp == 1) {
                    if(i+X-1 >=N) {
                        tf = true;
                        break;
                    }
                    samenum = map[i][j];
                    samecnt = 0;
                    for(int k=i+1;k<i+X;k++) {
                        if(samenum != map[k][j]) {
                            tf = true;
                            break;
                        }
                    }
                    if(tf) {
                        break;
                    }
                    else if(!tf) {
                        i = i+ X-1;
                    }
                }
                else {
                    samecnt++;
                }
            }
            if(!tf) {
                result++;
            }
        }
        return result;
    }
    static int horizen() {
        int cnt = 0,gung =0,samecnt=0,samenum=0,temp=0,aftercnt=0;
        int result =0;
        boolean tf = false;
        for(int i=0;i<N;i++) {
            tf = false;
            cnt =  gung = 0;
            samecnt =1; samenum = map[i][0];
            for(int j=1;j<N;j++) {
                temp = samenum - map[i][j];
                if(temp >1 || temp <-1) {
                    tf = true;
                    break;
                }
                else if(temp == -1) {
                    samenum = map[i][j];
                    if(samecnt >=X) { // 전에 경사로 설치가능?
                        samenum = map[i][j];
                        samecnt = 1;
                    }
                    else {
                        tf = true;
                        break;
                    }
                }
                else if (temp == 1) {
                    if(j+X-1 >=N) {
                        tf = true;
                        break;
                    }
                    samenum = map[i][j];
                    samecnt = 0;
                    for(int k=j;k<j+X;k++) {
                        if(samenum != map[i][k]) {
                            tf = true;
                            break;
                        }
                    }
                    if(tf) {
                        break;
                    }
                    else if(!tf) {
                        j = j+ X-1;
                         
                    }
                }
                else {
                    samecnt++;
                }
            }
            if(!tf) {
                result++;
            }
        }
        return result;
    }
}