import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer;
        
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        
        int size = answers.length;
        int onesize=one.length;
        int twosize=two.length;
        int threesize=three.length;
        System.out.println("qq");
        int score1=0,score2=0,score3=0;
        for(int i=0; i<size; i++) {
            if(answers[i] == one[i%onesize]) {
                score1++;
            }
            if(answers[i] == two[i%twosize]) {
                score2++;
            }
            if(answers[i] == three[i%threesize]) {
                score3++;
            }
        }
        int MAX = Math.max(score1,Math.max(score2,score3));
        int count=0;
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        if(score1 == score2 &&score2 == score3) {
            answer  = new int[3];
            answer[0] = 1;
            answer[1] = 2;
            answer[2] = 3;
        }
        else {
            if(MAX == score1) {
                arr1.add(1); 
            }
            if(MAX == score2) {
               arr1.add(2);
            }
            if(MAX == score3) {
                arr1.add(3);
            }
             answer = new int[arr1.size()];
        }
       
        for(int i=0; i<arr1.size();i++) {
            answer[i] = arr1.get(i);
        }
        
        
        return answer;
    }
}