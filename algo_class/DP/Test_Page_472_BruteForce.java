package  DP;
import java.util.Scanner;

public class Test_Page_472_BruteForce {
//  테스트 {1,5, 10, 16}	
	static int[] data = {1,4,6};
	static int[] sel;
	static int selCount = 0;
	static int minSelCount = Integer.MAX_VALUE;
	static int pay ;
    public static void main(String[] args) {        
        Scanner sc = new Scanner(System.in);        
        sel = new int[100];        
        System.out.println("거스름돈을 입력해주세요:");
        pay = sc.nextInt();        
        calc_change(0,0,0);        
        System.out.println("지불해야하는 거스름돈 개수 :" + minSelCount);
 
    }
    static void calc_change(int depth,int starti, int sum)
    {
        if( sum > pay){
            return ;
        }
        if( sum == pay ){
            for(int i=0;i<selCount;i++){
                System.out.print(sel[i] + " ");
            }
            System.out.println();
            if(minSelCount > selCount) {
            	 minSelCount = selCount;
            }           
            return ;
        }
        for(int i=starti;i<data.length;i++){
            sel[selCount] = data[i];
            sum = sum + data[i];
            selCount++;
            calc_change(depth+1,i,sum);
            selCount--;
            sum = sum - data[i];
        }
    }    
}
