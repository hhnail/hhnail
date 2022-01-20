package com.hhnail.datastructure.atguigu.tree;

/**
 * @author Hhnail
 * <p>
 * Java实现二叉树
 */
public class HBinaryTree {

	public static void main(String[] args) {
		HBinaryTree tree = new HBinaryTree();

		HTreeNode root = new HTreeNode(1, "张三");
		HTreeNode node2 = new HTreeNode(2, "李四");
		HTreeNode node3 = new HTreeNode(3, "王五");
		HTreeNode node4 = new HTreeNode(4, "赵六");
		HTreeNode node5 = new HTreeNode(5, "田七");
		HTreeNode node6 = new HTreeNode(6, "陈八");
		HTreeNode node7 = new HTreeNode(7, "朱九");

		node2.left = node4;
		node2.right = node5;
		root.left = node2;

		node3.left = node6;
		node3.right = node7;
		root.right = node3;

		tree.setRoot(root);

		tree.preorder();
		System.out.println("==================");
		tree.inorder();
		System.out.println("==================");
		tree.postOrder();

	}

	// constructor
	public HBinaryTree() {

	}

	// 根节点 field、setter
	private HTreeNode root;

	public void setRoot(HTreeNode root) {
		this.root = root;
	}

	// 前序遍历
	public void preorder() {
		if (root == null) {
			System.err.println("节点为空！");
		} else {
			root.preorder();
		}
	}

	// 中序遍历
	public void inorder() {
		if (root == null) {
			System.err.println("节点为空！");
		} else {
			root.inorder();
		}
	}

	// 后序遍历
	public void postOrder() {
		if (root == null) {
			System.err.println("节点为空！");
		} else {
			root.postOrder();
		}
	}


}
