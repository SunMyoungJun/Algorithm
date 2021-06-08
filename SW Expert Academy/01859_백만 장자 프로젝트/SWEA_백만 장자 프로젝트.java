import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
	static int[] num = new int[1000001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int test = 0, num_length = 0, num_value = 0, p_value = 0, count = 0;
	    long sell_sum = 0,final_sum = 0, buy_sum = 0, max = 0;
	    int head = 1;
	    boolean check1 = false, check2 = false;
	    
	   test = Integer.parseInt(br.readLine());
	 
	 
	    for (int t = 0; t < test; t++)    //test 횟수
	    {
	       num_length = Integer.parseInt(br.readLine());
	       st = new StringTokenizer(br.readLine());
	        for (int n = 0; n < num_length; n++) // 입력 숫자 개수
	        {
	            num[n] = Integer.parseInt(st.nextToken());
	        }
	        ////////////////// 시작
	        p_value = 0; buy_sum = 0; count = 0; sell_sum = 0; final_sum = 0;
	        for (int i = p_value; i < num_length; i++)
	        {
	            max = num[i];
	            for (int j = i + 1; j < num_length; j++)
	            {
	                if (num[j] > max) // 범위 내 최대값 구하기
	                {
	                    max = num[j];
	                    p_value = j;
	                    check1 = true;
	                }
	            }
	 
	            if (check1 == true)
	            {
	                for (int k = i; k < p_value; k++)
	                {
	                    buy_sum = buy_sum + num[k];
	                    count++;
	                }
	                check1 = false;
	                sell_sum = sell_sum + num[p_value] * count;
	                final_sum = final_sum + sell_sum - buy_sum;
	                count = 0; buy_sum = 0;sell_sum=0;
	                i = p_value;
	            }
	        }
	        System.out.println("#"+head+" "+final_sum);
	        head++;
	        for (int g = 0; g < num_length; g++)
	            num[g] = 0;
	    }
	}
}
