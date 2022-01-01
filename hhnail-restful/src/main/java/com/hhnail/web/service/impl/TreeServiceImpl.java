package com.hhnail.web.service.impl;

import com.hhnail.util.HTreeUtil;
import com.hhnail.web.bean.TreeNode;
import com.hhnail.web.mapper.TreeMapper;
import com.hhnail.web.service.TreeService;
import com.hhnail.web.vo.resp.AntdTreeDataVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

	@Override
	public List<AntdTreeDataVO> queryApiGroupTree() {
		List<TreeNode> treeNodes = treeMapper.selectList(null);
		// DO与VO属性key映射
		List<AntdTreeDataVO> voList = new ArrayList<>();
		for (TreeNode node : treeNodes) {
			AntdTreeDataVO vo = new AntdTreeDataVO();
			BeanUtils.copyProperties(node,vo);
			vo.setKey(node.getTreeId());
			vo.setTitle(node.getName());
			voList.add(vo);
		}
		// 构建树结构
		List<AntdTreeDataVO> treeData = HTreeUtil.createTree(voList);
		return treeData;
	}
}
