package com.hhnail.web.service.impl;

import com.hhnail.web.bean.TreeNode;
import com.hhnail.web.mapper.TreeMapper;
import com.hhnail.web.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeServiceImpl implements TreeService {

	@Autowired
	TreeMapper treeMapper;

	@Override
	public List<TreeNode> queryTreeData() {
		return treeMapper.selectList(null);
	}

	@Override
	public List<TreeNode> queryTreeNodeChildren(Integer pId) {
		return null;
	}
}
