
public class MyStack {
//문자 스택
	char[] map = new char[100];
	int top =-1;
	
//	push
	void push(char data) {
		top++;
		map[top] = data;
	}
	
//	pop
	char pop() {
//		char data = ' ';
//		if(top == -1) {
//			data = '\u0000';  //아무것도없다는 뜻.
//		}
//		else {
//			data = map[top];
//			top--;
//		}		
//		return data;
	
		return top == -1 ? '\u0000' : map[top--];
	
	}
	
	
	
//	size
	int size() {
		return top+1;  //그러나 어떤스택의 사이즈를 1억번 확인해야한다 하면 top+1연산을 1억번해버림 .
						//이럴땐 위에 size변수를 주고 push함수 발생할때마다 size도 같이 ++ 시켜주면 여기서 return size; 만해주면됨 .
						//반대로 push가 많이 일어나면 사이즈변수를 줬을 때 사이즈를 계속 ++ 해줘야해서 더 많은연산 일어남.
	}
//	isEmpty
	boolean isEmpty() {
		boolean flag = false;
		if(top == -1)
			flag = true;
		
	return flag;
//	또는 한줄로 return top== -1 ? true : false;
	}
//	peek
	
	char peek() {
		return top == -1 ? '\u0000' : map[top]; 
	}
	
	
	
	
	
	
	
}
