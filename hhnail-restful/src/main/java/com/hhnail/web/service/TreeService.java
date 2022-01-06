package com.hhnail.web.service;

import com.hhnail.web.bean.HColumn;
import com.hhnail.web.bean.HTable;
import com.hhnail.web.bean.TreeNode;
import com.hhnail.web.vo.resp.AntdTreeDataVO;
import com.hhnail.web.vo.resp.TreeNodeVO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TreeService {

	List<TreeNode> queryTreeData();

	List<TreeNode> queryTreeNodeChildren(Integer pId);

	List<AntdTreeDataVO> queryApiGroupTree();

	List<HTable> queryTable();

	List<HColumn> queryColumn(String tableName);
}
