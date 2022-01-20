package com.hhnail.datastructure.atguigu.tree;

/**
 * 顺序存储二叉树
 */
public class OrderBinaryTree {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		OrderBinaryTree obt = new OrderBinaryTree(arr);
		// obt.preOrder();
		// obt.inOrder();
		obt.postOrder();
	}

	private int[] treeArray;

	private int length;

	public OrderBinaryTree(int[] treeArray) {
		this.treeArray = treeArray;
		this.length = treeArray.length;
	}

	public void preOrder() {
		this.preOrder(0);
	}

	/**
	 * 前序遍历
	 *
	 * @param index
	 */
	public void preOrder(int index) {
		System.out.println(treeArray[index]);
		// 当前节点的左节点index为 2n+1；右节点index为 2n+2
		int lp = 2 * index + 1;
		int rp = 2 * index + 2;
		if (lp < this.length) {
			preOrder(lp);
		}
		if (rp < this.length) {
			preOrder(rp);
		}
	}

	public void inOrder() {
		this.inOrder(0);
	}

	/**
	 * 中序遍历
	 *
	 * @param index
	 */
	public void inOrder(int index) {
		int lp = 2 * index + 1;
		int rp = 2 * index + 2;
		if (lp < this.length) {
			inOrder(lp);
		}
		System.out.println(treeArray[index]);
		if (rp < this.length) {
			inOrder(rp);
		}
	}


	public void postOrder() {
		this.postOrder(0);
	}

	/**
	 * 后序遍历
	 *
	 * @param index
	 */
	public void postOrder(int index) {
		int lp = 2 * index + 1;
		int rp = 2 * index + 2;
		if (lp < this.length) {
			postOrder(lp);
		}
		if (rp < this.length) {
			postOrder(rp);
		}
		System.out.println(treeArray[index]);
	}

}
