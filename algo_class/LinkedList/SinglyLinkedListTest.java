package com.ssafy.linkedlist;

public class SinglyLinkedListTest {

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.addLastNode("성지은");
		System.out.println(list.getLastNode());
		list.printList();
		
		list.addLastNode("당현아");
		list.printList();
		
		list.addFirstNode("김민정");
		list.printList();
		
		
		Node preNode = list.getNode("성지은");
		list.insertAfterNode(preNode, "서요셉");
		list.printList();

		System.out.println(list.getPreviousNode(list.getNode("당현아")));
	
		list.deleteNode("성지은");
		list.printList();
		list.deleteNode("당현아");
		list.printList();
		list.deleteNode("김민정");
		list.printList();
		list.deleteNode("서요셉");
		list.printList();
	}

}
