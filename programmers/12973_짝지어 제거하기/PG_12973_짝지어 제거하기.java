import java.util.*;
class Solution
{
    public int solution(String s)
    {
        Stack<Character> st = new Stack<>();
        int answer = 0;
        int len = s.length();
        char alpa;
        st.push(s.charAt(0));
        for(int i=1; i<len; i++) {
            alpa = s.charAt(i);
            if(st.size() !=0 && st.peek() == alpa) {
                st.pop();
            }
            else {
                st.push(alpa);
            }
        }
        
        if(st.size() ==0) {
            answer = 1;
        }
        return answer;
    }
}