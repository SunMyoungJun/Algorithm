public class Solution {
	int[] answer,temp;
	int maxScore=-100;
	int[] infos;
	public int[] solution(int n, int[] info) {
		answer = new int[11];
		temp = new int[11];
		infos = info;

		dfs(0,0,0,n);
		
		if(maxScore <= 0) {
			answer = new int[1];
			answer[0] = -1;
		}

		return answer;
	}
	
	
	
	
	void dfs(int idx,int score1,int score2,int cnt) {
		
		if(idx == 11) {
			if(maxScore < (score1 - score2)) {
				maxScore = score1 - score2;
				
				for(int i=0; i<11; i++) {
					answer[i] = temp[i];
				}
				
				if(cnt >0) {
					answer[10] += cnt;
				}
			}
			
			else if(maxScore == (score1 - score2)) {
				if(cnt >0) {
					temp[10] += cnt;
				}
				
				
				for(int i=10; i>=0; i--) {
					if(answer[i] > temp[i]) {
						break;
					}
					else if(answer[i] < temp[i]) {
						for(int j=0; j<11; j++) {
							answer[j] = temp[j];
						}
						break;
					}
				}
				
			}
	
			return;
		}
		
		
		
		if(cnt-infos[idx] >0) {
			temp[idx] = infos[idx]+1;
			dfs(idx+1,score1+(10-idx),score2,cnt-infos[idx]-1);
			temp[idx] = 0;
		}
		
		
		if(infos[idx] >0) {
			dfs(idx+1,score1,score2+(10-idx),cnt);
		}
		else {
			dfs(idx+1,score1,score2,cnt);
		}
	
		
		
	}
	
	
}
