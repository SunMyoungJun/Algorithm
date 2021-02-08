package com.ssafy.linkedlist;

//배열 : 메모리최적화, 선택작업 무지막지많음, 삽입 삭제에 불리
//리스트 : 메모리 낭비, 선택작업 별로 없음, 삽입,삭제가 많으면 유리


public class SinglyLinkedList { //단순연결리스트 구현 + 헤드관리

	private Node head;

	//	연결리스트에 첫번째 원소로 삽입하기
	public void addFirstNode(String data) { //연결리스트에 첫번째 원소로 삽입하기
		Node newNode = new Node(data, head);
		head = newNode;
	}

	public Node getLastNode() { //연결리스트에 마지막 원소 찾기
		Node currNode = head;

		while(currNode.link !=null) {
			currNode = currNode.link;
		}
		return currNode;
	}


	public void addLastNode(String data) { // 연결리스트에 마지막 원소로 삽입하기

		if(head ==null) {
			addFirstNode(data);
			return;
		}

		Node lastNode = getLastNode();
		Node newNode = new Node(data,null); //null안넣어도 자동 null됨.
		lastNode.link = newNode;
	}

	public void insertAfterNode(Node preNode,String data) {
		if(preNode ==null) {
			System.out.println("선행노드가 없어 삽입이 불가능합니다.");
			return;
		}

		Node newNode = new Node(data,preNode.link);
		preNode.link = newNode;
	}

	public Node getNode(String data) {

		for(Node currNode =head;currNode !=null ;currNode=currNode.link) {
			if(currNode.data.equals(data)) {
				return currNode;
			}
		}

		return null;
	}

	public Node getPreviousNode(Node target) { //어떤 노드의 이전 노트를 탐색하는 메서드
		Node currNode = head,nextNode =null;

		if(currNode !=null) {
			while((nextNode = currNode.link)!= null) {
				if(nextNode == target) {
					return currNode;
				}
				currNode = nextNode;  //tartget 못찾았을떄
			}
		}
		return null;
	}

	public void deleteNode(String data) { //data를 값으로가지는 노드 삭제
		if(head ==null) { //공백리스트
			System.out.println("공백리스트여서 삭제가 불가능합니다.");
			return;
		}
		Node targetNode = getNode(data);
		if(targetNode ==null) { //data를 값으로가지는 노드가 없으면 null임
			return;
		}

		Node preNode = getPreviousNode(targetNode);

		if(preNode == null && targetNode ==head) { //둘중에하나만 써도되는데 그냥 이중검사 한것.
			head = targetNode.link;
		} else {
			preNode.link = targetNode.link;
		}
		targetNode.link =null;
	}

	
	public void printList() {
		System.out.print("L =   (    ");
		for(Node currNode =head; currNode != null; currNode = currNode.link) {
			System.out.print(currNode.data+" ");
		}
		System.out.println("   )");
	}	
}
