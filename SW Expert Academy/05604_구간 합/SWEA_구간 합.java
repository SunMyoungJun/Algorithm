import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
 
public class Solution{
    static long A,B,S;
    static HashMap<Long, Long> m=new HashMap<Long, Long>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        m.clear();
        for (int i = 1; i < 17; i++) { 
            long v=power(0+i);
            m.put((v-1L), h(v-1));
        }
     
        for (int t = 1; t <test+1; t++) {
            st = new StringTokenizer(br.readLine());
            A= Long.parseLong(st.nextToken());
            B= Long.parseLong(st.nextToken());
            S=cal(B,A);
            sb.append("#").append(t).append(" ").append(S).append("\n");
        }
        System.out.println(sb.toString());
    }
    static long h(long n) {
        long len=len(n)+1L;
        return ((45L)*(len)*(1L+n))/(10L);
    }
    static long cal(long B,long A){
        if(A<=1){
            return a_func(B);
        }else if(A==B){
            return a_func(B)-a_func(A-1);    
        }else{
            return a_func(B)-a_func(A-1);
        }
    }
    static long g_func(long n){
        if(n<=9){
            return e_func(n);
        }else{
            long v=power(len(n));
            return (n/v)*(n%v+1L)+ a_func(n%v);
        }
    }
    static long a_func(long n) {
        if(m.containsKey(n)) {
            return m.get(n);
        }else if(n<=9){
            return e_func(n);
        }else{
            long v=power(len(n));
            m.put(n, a_func(n-1L-n%v)+g_func(n));
            return m.get(n);
        }
    }
    static long e_func(long n){
        return n*(n+1)/2;
    }
    static long len(long n){
        return 0+(n+"").length()-1;
    }
    static long power(long n){
        return (long)Math.pow(10, n);
    }
}