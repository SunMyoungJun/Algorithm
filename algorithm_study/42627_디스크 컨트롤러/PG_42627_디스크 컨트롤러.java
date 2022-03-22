import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0,idx2=0,idx3=0,cnt=0;
        int[] p1;
        PriorityQueue<int[]> pq1 = new PriorityQueue<int[]>(new Comparator<int[]>() {
           @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    return (o1[0] > o2[0]) ? 1: -1;
                }
                else {
                    return (o1[1] > o2[1]) ? 1: -1;
                }
            }
        });
        int jobsize=jobs.length;
        ArrayList<int[]>[] arr1 = new ArrayList[1001];
        
        for(int i=0; i<1001; i++) {
            arr1[i] = new ArrayList<int[]>();
        }
        
        for(int i=0; i<jobsize; i++) {
            arr1[jobs[i][0]].add(new int[] {jobs[i][0],jobs[i][1]});
        }
        
        int size = 0;
        int idx=0;
        
        while(true) {
            if(pq1.isEmpty()) {
                 for(int i=idx; i<1001; i++) {
                    size = arr1[i].size();
                    if(size !=0) {
                      for(int j=0; j<size; j++) {
                         pq1.offer(arr1[i].get(j));
                       }
                        idx = i;
                        break;
                     }
                }
            }
            
            while(!pq1.isEmpty()) {
                cnt++;
                p1 = pq1.poll();
                idx2 = idx + p1[1];
                answer = answer + (idx2 - p1[0]);
                idx3 = (idx2 >1000) ? 1000 : idx2;
                for(int i=idx+1; i<=idx3; i++) {
                    size = arr1[i].size();
                    for(int j=0; j<size; j++) {
                        pq1.offer(arr1[i].get(j));
                    }
                }
                idx = idx2;
            }
            if(cnt == jobsize) {
                break;
            }
        }
        answer = answer/cnt;        
        
        
        return answer;
    }
}