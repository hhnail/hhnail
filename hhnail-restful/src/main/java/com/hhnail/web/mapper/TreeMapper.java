package com.hhnail.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hhnail.web.bean.HColumn;
import com.hhnail.web.bean.HTable;
import com.hhnail.web.bean.TreeNode;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreeMapper extends BaseMapper<TreeNode> {

	List<HTable> queryTable();

	List<HColumn> queryColumn(@Param("tableName") String tableName);

}
