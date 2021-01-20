import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static Node[] nodearr;
	
	
	 static class Node {
		char val; //트리 번호
		Node leftNode;
		Node rightNode;
		

	}
	
	
	 public static Node createNode(char val,Node leftNode,Node rightNode)
	 {
		 Node node = new Node();
		 node.val = val;
		 node.leftNode = leftNode;
		 node.rightNode = rightNode;
		 return node;
	 }

	 public static void preorder(Node node) //중위 순회
	 {
		 System.out.print(node.val);
		 if(node.leftNode !=null)
			 preorder(node.leftNode);
		 if(node.rightNode != null)
			 preorder(node.rightNode);
		 
	 }
	
	 public static void inorder(Node node)
	 {
		 if(node.leftNode !=null)
			 inorder(node.leftNode);
		 System.out.print(node.val);
		 if(node.rightNode !=null)
			 inorder(node.rightNode);
	 }
	
	 public static void postorder(Node node)
	 {
		 if(node.leftNode !=null)
			 postorder(node.leftNode);
		 if(node.rightNode != null)
			 postorder(node.rightNode);
		 
		 System.out.print(node.val);
		 
	 }
	public static void main(String[] args) throws IOException {
		
		 	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int input = Integer.parseInt(br.readLine());
		 nodearr = new Node[input];
		
		for(int i=0; i<input; i++)
		{
			nodearr[i] = createNode(' ',null,null);
		}
		
		
		
		String[] temp = new String[3];
		
		int me,leftnum,rightnum;
		for(int i=0;i<input;i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++)
				temp[j] = st.nextToken();
			
			
			me = temp[0].charAt(0) - 65;
			leftnum = temp[1].charAt(0) -65;
			rightnum = temp[2].charAt(0) -65;
			nodearr[me].val = temp[0].charAt(0);
			
			nodearr[me].leftNode = (temp[1].charAt(0) != '.') ? nodearr[leftnum] : null;
			nodearr[me].rightNode = (temp[2].charAt(0) !='.') ? nodearr[rightnum] : null;
			
		}
		preorder(nodearr[0]);
		System.out.println();
		inorder(nodearr[0]);
		System.out.println();
		postorder(nodearr[0]);
	}

}
