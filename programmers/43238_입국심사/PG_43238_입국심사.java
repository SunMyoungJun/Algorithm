import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
		long start=0,end=0,mid=0;
		long sum=0;
		int len = times.length;
		Arrays.sort(times);
		
		end = (long) times[len-1] *n;
		
		while(start <=end) {
			mid = (start+end)/2;
			sum=0;
			
			for(int i=0; i<len; i++) {
				sum += mid / times[i];
			}
			
			if(sum < n) {
				start = mid+1;
			}
			else {
				end = mid-1;
				answer = mid;
			}
		}
		
		return answer;
    
    }
}