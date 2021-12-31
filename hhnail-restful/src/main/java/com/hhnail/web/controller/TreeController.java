package com.hhnail.web.controller;

import com.hhnail.web.bean.TreeNode;
import com.hhnail.web.service.TreeService;
import com.hhnail.util.HTreeUtil;
import com.hhnail.web.vo.resp.AntdTreeDataVO;
import com.hhnail.web.vo.resp.TreeNodeVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class TreeController {

	@Autowired
	TreeService treeService;

	@GetMapping("queryTreeData")
	public List<TreeNode> queryTreeData() {
		List<TreeNode> treeData = treeService.queryTreeData();
		// DO与VO属性key映射

		// 构建树结构
		// List<TreeNode> resp = HTreeUtil.createTree(treeData);
		List<TreeNode> resp = HTreeUtil.createCascaderTree(treeData);

		log.debug("tree data = {}", resp);

		return resp;
	}

	@PostMapping("queryTreeNodeChildren")
	public List<TreeNode> queryTreeNodeChildren(@RequestParam Integer pId) {
		List<TreeNode> resp = treeService.queryTreeNodeChildren(pId);
		return resp;
	}

	@GetMapping("queryApiGroupTree")
	public List<AntdTreeDataVO> queryApiGroupTree() {
		List<AntdTreeDataVO> apiGroup = treeService.queryApiGroupTree();
		log.debug("tree data = {}", apiGroup);
		return apiGroup;
	}

}
