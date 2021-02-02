import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] arr1 = new int[100];
        for(int i=1;i<11;i++)
        {
            int c =0;
            int height=0;
            int dump = Integer.parseInt(br.readLine());
            st  = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens())
            {
                height = Integer.parseInt(st.nextToken()); 
                arr1[c] =height;
                c++;
            }
             
             
            while(dump-- !=0)
            {
                Arrays.sort(arr1);
                arr1[99] -=1;
                arr1[0] +=1;
                 
            }
            Arrays.sort(arr1);
            int num = arr1[99] - arr1[0];
            System.out.println("#"+i+" "+num);
        }
         
    }   
 
}