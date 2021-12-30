package com.hhnail.web.service;

import com.hhnail.web.bean.TreeNode;

import java.util.List;

public interface TreeService {

	List<TreeNode> queryTreeData();

	List<TreeNode> queryTreeNodeChildren(Integer pId);
}
