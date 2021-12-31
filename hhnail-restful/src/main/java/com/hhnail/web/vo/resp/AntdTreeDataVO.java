package com.hhnail.web.vo.resp;

import io.swagger.models.auth.In;
import lombok.Data;

import java.util.List;

@Data
public class AntdTreeDataVO {

	// 前端所需
	private Integer key;
	private String title;

	// 后端构建树所需
	private Integer level;
	private Integer leafy;
	private Integer pId;

	//
	private List<AntdTreeDataVO> children;
}
