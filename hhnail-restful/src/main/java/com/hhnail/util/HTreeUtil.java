package com.hhnail.util;

import com.hhnail.web.bean.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HTreeUtil {

	/**
	 * TODO
	 * 根据数据库平面结构构建树
	 */
	public static List<TreeNode> createTree(List<TreeNode> nodes){
		Iterator<TreeNode> iterator = nodes.iterator();
		while (iterator.hasNext()){
			TreeNode node = iterator.next();
			// 叶子节点无需再添加
			if(node.getLeafy() == 1){
				return null;
			}

		}
		return null;
	}


	/**
	 * 将List转化为Antd Cascader组件所需结构
	 *
	 * @param source 树节点。各节点处在同一平面内的List
	 * @return Tree形结构
	 */
	public static List<TreeNode> createCascaderTree(List<TreeNode> source) {
		List<TreeNode> target = new ArrayList<TreeNode>();
		for (TreeNode treeNode : source) {
			if (treeNode.getLevel() == 1) {
				for (TreeNode node2 : source) {
					if ((node2.getLevel() == 2) && (node2.getPId() == treeNode.getTreeId()) && node2.getLeafy() == 0) {
						for (TreeNode node3 : source) {
							if ((node3.getLevel() == 3) && (node3.getPId() == node2.getTreeId())) {
								node2.getChildren().add(node3);
							}
						}
						treeNode.getChildren().add(node2);
					}
				}
				target.add(treeNode);
			}
		}
		return target;
	}
}
