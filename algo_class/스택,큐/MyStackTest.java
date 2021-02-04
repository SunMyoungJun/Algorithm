import java.util.Stack;

public class MyStackTest {


	public static void main(String[] args) {
//		MyStack stack = new MyStack(); 직접만든 스택클래스
		Stack<Character> stack = new Stack();
		stack.push('A');
		stack.push('B');
		stack.push('C');
		System.out.println("갯수 : "+ stack.size());
		System.out.println(stack.peek());
		System.out.println("갯수 : "+ stack.size());
		System.out.println(stack.pop()); //1
		System.out.println("갯수 : "+ stack.size());
		System.out.println(stack.pop()); //2
		System.out.println(stack.pop()); //3
//		System.out.println(stack.pop()); //4  //3개 넣고 4개 빼면 ?  공백출력!!(내가만든 Mystack으로할떄)
											//3개 넣고 4개 빼면? java자체 stack imp2ort하면? 실행 시 오류!! 컴파일때 오류 아님
											//따라서 peek 이나 pop 할떄는 if(stack.isEmpty()) 안에 쓰자
		System.out.println("end");
	}

}
