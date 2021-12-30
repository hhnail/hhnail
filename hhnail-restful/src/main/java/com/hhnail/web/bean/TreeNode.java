package com.hhnail.web.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.hhnail.web.enums.TreeNodeType;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TreeNode {

	@TableField(exist = true)
	private Integer treeId;

	private String name;

	private Integer pId;

	private Integer level;

	// 形容词替换 isLeaf，来满足避免is开头的Java开发规范
	private Integer leafy;

	private TreeNodeType type;

	private Integer deleted;

	// exist = false 表示不会将其与数据库进行映射，否则数据库没有这个字段就会报错！
	@TableField(exist = false)
	private List<TreeNode> children = new ArrayList<>();
}
