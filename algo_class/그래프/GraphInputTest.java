import java.util.ArrayList;
import java.util.Scanner;

public class GraphInputTest {

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int cnt = sc.nextInt();
    
    ArrayList<Integer> [] graph = new ArrayList[N];
    
    for(int i = 0; i < N; i++) {
        graph[i] = new ArrayList<Integer>();
    }
    int from, to;
    for(int i = 0; i < cnt; i++) {
        from = sc.nextInt();
        to = sc.nextInt();
        graph[from].add(to); //유향 그래프 였으면
        graph[to].add(from); //무향 그래프 였으면
    }
    
    for(int i = 0 ; i < graph.length; i++) {
        ArrayList<Integer> temp = graph[i];
        System.out.print("from : " + i + " to ");
        for(Integer data : temp) {
            System.out.print(" " + data );
        }
        System.out.println();
    }
}
//    class Data{
//        int to;
//        int weight;
//    }

}

