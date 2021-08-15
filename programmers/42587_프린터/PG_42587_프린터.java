
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
37
38
39
40
41
42
43
44
45
46
47
48
49
50
51
52
53
54
import java.util.*;
class Solution {
   static class Node {
       int num,score;

       public Node(int num,int score) {
           this.num = num;
           this.score = score;
       }
   }
    public int solution(int[] priorities, int location) {
        Queue<Node> q1 = new LinkedList<Node>();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int size = priorities.length;

        for(int i=0; i<size; i++) {
            q1.offer(new Node(i,priorities[i]));
            if(map.containsKey(priorities[i])) {
                map.put(priorities[i],map.get(priorities[i])+1);
            }
            else {
                map.put(priorities[i],1);
            }
        }
        Node p1;
        int num=0,score=0,cnt=0;
        while(true) {
            p1 = q1.poll();
            num = p1.num;
            score = p1.score;

            if(map.lastKey() == score) {
                cnt++;
                if(map.get(map.lastKey()) >1) {
                    map.put(map.lastKey(),map.get(map.lastKey())-1);
                }
                else {
                    map.remove(map.lastKey());
                }

                if(num == location) {
                    break;
                }
            }
            else {
                q1.offer(p1);
            }
        }


        return cnt;
    }
}
