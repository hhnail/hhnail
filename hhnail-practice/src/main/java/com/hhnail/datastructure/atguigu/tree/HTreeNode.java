package com.hhnail.datastructure.atguigu.tree;

import lombok.Data;

/**
 * 树节点
 */
public class HTreeNode {

	public Integer id;

	public String name;

	public HTreeNode left;

	public HTreeNode right;

	public HTreeNode(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "HTreeNode{id=" + id + ", name='" + name + '}';
	}

	// 先序遍历/前序（前、中、后指的是父节点的打印位置处在三个节点中的前、中、后位置）
	public void preorder() {
		System.out.println(this);
		if (this.left != null) {
			this.left.preorder();
		}
		if (this.right != null) {
			this.right.preorder();
		}
	}

	// 中序遍历
	public void inorder() {
		if (this.left != null) {
			this.left.inorder();
		}

		System.out.println(this);

		if (this.right != null) {
			this.right.inorder();
		}
	}

	// 后序遍历
	public void postOrder() {
		if (this.left != null) {
			this.left.postOrder();
		}
		if (this.right != null) {
			this.right.postOrder();
		}
		System.out.println(this);
	}
}
