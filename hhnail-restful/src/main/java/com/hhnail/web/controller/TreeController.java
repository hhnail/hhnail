package com.hhnail.web.controller;

import com.hhnail.web.bean.TreeNode;
import com.hhnail.web.service.TreeService;
import com.hhnail.web.util.HTreeUtil;
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
	public List<TreeNode> queryTreeData(){
		List<TreeNode> treeData = treeService.queryTreeData();
		// List<TreeNode> resp = HTreeUtil.createTree(treeData);
		List<TreeNode> resp = HTreeUtil.createCascaderTree(treeData);

		log.debug("tree data = {}", resp);
		return resp;
	}

	@PostMapping("queryTreeNodeChildren")
	public List<TreeNode> queryTreeNodeChildren(@RequestParam Integer pId){
		List<TreeNode> resp = treeService.queryTreeNodeChildren(pId);
		return resp;
	}



}
