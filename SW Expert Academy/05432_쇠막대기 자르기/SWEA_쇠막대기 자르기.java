import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> s = new Stack<>();
        String stick=null;
        int sum=0;
        char temp=' ';
        int test= Integer.parseInt(br.readLine());
 
        for(int t=1;t<test+1;t++) {
            stick = br.readLine();
            for(int i=0;i<stick.length();i++) {    
                if(stick.charAt(i) =='(') {    
                    s.push(stick.charAt(i));
                    temp = stick.charAt(i);      
                }
                else {
                    if(temp == ')'){          
                        temp = s.pop();         
                        temp = stick.charAt(i); 
                        sum++;                  
                        continue;
                    }       
                    temp = s.pop();             
                    temp = stick.charAt(i);     
                    sum +=s.size();             
                }
            }
            System.out.println("#"+t+" "+sum);
            sum=0; 
        }
    }
}