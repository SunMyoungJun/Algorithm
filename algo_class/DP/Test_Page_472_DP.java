package day19;
import java.util.Scanner;

//이번에는 DP를 활용하여 조금 더 실용적인 문제를 작성해보자. 
//가령 7840원짜리 물건을 사기위해 1만원을 지불했다면 
//우리는 거스름돈으로 2160원을 받아야 할 것이다. 
//우리나라 동전 체계가 1원, 3원, 4원으로 구성되어 있다고 가정하면 
//이 때, 최소의 개수로 동전을 지급하는 방법에 대해 구해보자.
//
//우선 거스름돈이 10원인 경우 무조건 1원짜리 동전 한개를 지불해야 한다.
//마찬가지로 거스름돈이 3, 4원이라면 각각의 동전 한개를 지불하면 된다. 
//그 이상의 동전을 지급해야 한다면 어떻게 하면 좋을까, 
//지불해야 하는 금액 기준으로 1원, 3원, 4원 덜 지불하는 경우 
//최소값을 구하면 된다. 
//5원을 지불해야 하는 케이스라면 5원에서 1원, 3원, 4원을 빼서 
//지불해야하는 동전 개수 중 최소값이 무엇인지를 구하고, 
//해당 개수에서 동전을 1개 증가 시키면 지불이 쉽다. 
//각각의 동전을 무한대로 있다고 가정하자.
public class Test_Page_472_DP {
	static int[] change;	 
    public static void main(String[] args) {        
        Scanner sc = new Scanner(System.in);        
        change = new int[100];        
        System.out.println("거스름돈을 입력해주세요:");
        int i = sc.nextInt();        
        calc_change();        
        System.out.println("지불해야하는 거스름돈 개수 :" + change[i]);
 
    }
    
    static void calc_change(){
        change[0] = 0; 
        change[1] = 1;
        for(int i=2; i<100; i++){
            change[i] = min_change(i)+1;
        }        
    }    
    static int min_change(int i){
        int min = change[i-1];
        if(i>=4){
            if(min>change[i-4]) min = change[i-4];
        }
        if(i>=6){
            if(min>change[i-6]) min = change[i-6];
        }
        return min;
    } 
}
