package algorithm;

public class PG_kakao_4 {
	static int[] info2 = new int[11];
	static int[] min = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
	static int[] score = {10,9,8,7,6,5,4,3,2,1,0};
	static int n=10,oneSum;
	public static void main(String[] args) {
		n=10;
		int[] info = {0,0,0,0,0,0,0,0,3,4,3};
		int[] answer;
		int info_len = info.length;
	
		
		
		dfs(0,info);
		if(min[11] == 0) {
			answer = new int[1];
			answer[0] = -1;
		}
		else {
			answer = new int[11];
			for(int i=0; i<11;i++) {
				answer[i] = min[i];
			}
		}
		
		
		for(int i=0; i<answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
	
	static void beScore(int[] info) {
		int sum=0;
		int sum1=0;
		int sum2=0;
		for(int i=0;i<11;i++) {
			if(info[i] ==0 && info2[i] ==0) {
				continue;
			}
			
			if(info2[i] > info[i]) {
				sum1 += score[i]; 
			}
			else {
				sum2 += score[i];
			}
		}
		
	
		
		
		if(sum1 <=sum2) {
			return;
		}
		sum = sum1 - sum2;
		
	
		
		
		if(min[11] > sum) {
			return;
		}
		
		if(min[11] < sum) {
			for(int i=0; i<11;i++) {
				min[i] = info2[i];
			}
			min[11] = sum;
		}
	
		
		else if(min[11] == sum) {
			for(int i=10; i>=0; i--) {
				if(min[i] == info2[i]) {
					continue;
				}
				if(min[i] > info2[i]) {
					return;
				}
				if(min[i] < info2[i]) {
					for(int j=0; j<11; j++) {
						min[j] = info2[j];
					}
					return;
				}
			}
		}
		
		
	
	}
	
	
	static void dfs(int cnt,int[] info) {
		int temp=0;
		if(cnt == n) {
			beScore(info);
			return;
		}
		for(int i=0; i<11; i++) {
			if(info2[i] > info[i]) {
				continue;
			}
			temp = info[i] +1;
			if(cnt+temp > n) {
				temp = n - cnt;
			}
			info2[i] =temp;
		
			dfs(cnt+temp,info);
			info2[i] -=temp;
		}
	}
	
	

}
