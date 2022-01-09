import java.util.*;
class Solution {
   
    public int[] solution(String[] genres, int[] plays) {
        int[] answer;
        int gsize = genres.length;
        ArrayList<Integer> arr1 = new  ArrayList<>();
        StringBuilder sb = new StringBuilder();
        HashMap<String,Integer> map = new HashMap<>();
        TreeMap<Integer,Integer> map2 = new TreeMap<>(Collections.reverseOrder());
        int idx=0,idx1=0,idx2=0;
        for(int i=0; i<gsize; i++) {
            if(map.get(genres[i]) != null) {
                continue;
            }
            map.put(genres[i],idx++);
        }
        
        int len = map.size();
        int playsLen= plays.length;
        int[] what = new int[len];
        
        for(int i=0; i<playsLen; i++) {
            idx1 = map.get(genres[i]);
            what[idx1] += plays[i];
        }
        
        for(int i=0; i<len; i++) {
            map2.put(what[i],i);
        }
        
        // Arrays.sort(what);
        
        
        PriorityQueue<int[]> pq1 = new PriorityQueue<int[]>(new Comparator<int[]>() {
           @Override
            public int compare(int[] o1,int[] o2) {
                if(o1[1] == o2[1]) {
                    return (o1[0] > o2[0]) ? 1: -1;
                }
                else {
                    return (o1[1] < o2[1]) ? 1: -1;
                }
            }
        });
        for(Integer num : map2.keySet()) {
            idx = map2.get(num);
            pq1.clear();
            for(int i=0; i<playsLen; i++) {
                idx1 = map.get(genres[i]);
                if(idx == idx1) {
                    pq1.offer(new int[] {i,plays[i]});
                }
            }
            int count=2;
            while(!pq1.isEmpty()) {
                int[] p1 = pq1.poll();
                count--;
                // sb.append(p1[0]+" ");
                arr1.add(p1[0]);
                if(count ==0) {
                    break;
                }
            }
            
            
        }
        answer = new int[arr1.size()];
        for(int i=0; i<arr1.size(); i++) {
            answer[i] = arr1.get(i);
        }
        
    
        
        
        
        
        return answer;
    }
}