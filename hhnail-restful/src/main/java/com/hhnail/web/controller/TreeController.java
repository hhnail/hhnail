package com.hhnail.web.controller;

import com.hhnail.web.bean.HColumn;
import com.hhnail.web.bean.HTable;
import com.hhnail.web.bean.TreeNode;
import com.hhnail.web.service.TreeService;
import com.hhnail.util.HTreeUtil;
import com.hhnail.web.vo.resp.AntdTreeDataVO;
import com.hhnail.web.vo.resp.TreeNodeVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
		log.debug("==2 tree data = {}", apiGroup);
		return apiGroup;
	}

	@PostMapping("queryTable")
	public List<HTable> queryTable() {
		List<HTable> tables = treeService.queryTable();
		log.debug("==3 tables = {}", tables);
		return tables;
	}

	@PostMapping("queryColumn")
	public List<HColumn> queryColumn(@RequestParam(value = "tableName") String tableName) {
		List<HColumn> columns = treeService.queryColumn(tableName);
		log.debug("==3 columns = {}", columns);
		return columns;
	}

	// @PostMapping("tree")
	// public List<HColumn> tree(@RequestParam(value = "tableName") String tableName) {
	//
	// }

}
