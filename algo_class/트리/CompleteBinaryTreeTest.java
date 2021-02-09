package com.ssafy.tree;

public class CompleteBinaryTreeTest {

	public static void main(String[] args) {
		int size =9;
		CompleteBinaryTree tree = new CompleteBinaryTree(size);
	
		for (int i = 0; i < size; i++) {
			tree.add((char)(65+i));   //대문자 A B C D ---이렇게 집어 넣음.
		}
		
//		tree.bfs();
//		tree.bfs2();
		tree.dfs(1);
	}

}

//			입력 트리 이런모양임.
//				A
//			 B     C
//			D  E  F  G
//		  H  I