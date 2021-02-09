package com.ssafy.tree;

public class HeepTest {

	static class MaxHeapTree{
		int[] datas;
		int MAX_SIZE;
		int size;
		public MaxHeapTree() {
			this(100);
		}
		public MaxHeapTree(int size) {
			MAX_SIZE = size;
//			0번 버리고 1번째부터 사용함
			datas = new int[MAX_SIZE + 1];
			size = 0;
		}
		public boolean isEmpty() {
			if(size == 0) {
				return true;
			}else {
				return false;
			}
		}
		public boolean isFull() {
			if(size == MAX_SIZE) {
				return true;
			}else {
				return false;
			}
		}
		public void insert(int data) {
			if(isFull()) {
				System.out.println("full");
				return;
			}
			size++; //힙크기 하나  증가하고 마지막 노드에 data 삽입
			datas[size] = data;
			int idx = size; //현재 위치 변수 설정
			while( idx > 1 && datas[idx] > datas[idx/2] ) { //자식것이 크면 교환
				swap(datas, idx, idx/2);
			}			
		}
		public int delete() {			
			int result = -1; // 없으면 반환되는값
			if(size == 0) {
				return -1;
			}
			result = datas[1]; // 무조건 첫번재 값 반환
			datas[1] = datas[size]; //마지막 위치값을 첫번째 위치값으로 설정
			datas[size] = 0; // 마지막 데이터를 지움
			size--; // 사이즈 하나 줄임
//			그런 후 힙을 재정렬한다.
			heapify();
			return result;
		}
		public void heapify() { // 내부의 데이터를 heap 구조로 만드는 작업  (log N)
//			첫번째 있던  정보와 그 자식노드와 비교해서 자식노드가 크면 그 노드와 변경하면서 가장 아래 level까지한다.
			int idx = 1;
			while(idx*2 <= size) {
				if(datas[idx] >= datas[idx*2] && datas[idx] >= datas[idx*2 + 1]) {
					break;
				}else {
//					그렇지 않으면 두 자식 중에 큰 값을 가진것과 교환한다.
					if(datas[idx *2] > datas[idx *2 + 1]) {
						swap(datas, idx, idx *2);
						idx = idx*2;
					}else {
						swap(datas, idx, idx *2 + 1);
						idx = idx*2 + 1;
					}
				}
			}
		}
		public void print() {
			for(int i = 1; i <=size; i++) {
				System.out.print(datas[i] + " ");
			}
			System.out.println();
		}
		
	}
	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void main(String[] args) {
		MaxHeapTree heap = new MaxHeapTree(5);
		heap.insert(1);
		heap.insert(1);
		heap.insert(5);
		heap.insert(5);
		heap.insert(2);
		System.out.println(heap.delete());
		System.out.println(heap.delete());
		System.out.println(heap.delete());
		System.out.println(heap.delete());
		System.out.println(heap.delete());
//		heap.insert(5); overflaw
		heap.print();
//		System.out.println(heap.isEmpty());
//		System.out.println(heap.isFull());

	}

}
