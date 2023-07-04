package com.hhnail.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hhnail.web.bean.HColumn;
import com.hhnail.web.bean.HTable;
import com.hhnail.web.bean.TreeNode;
import com.hhnail.web.bean.WeChatFollower;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeChatMapper extends BaseMapper<WeChatFollower> {


}
