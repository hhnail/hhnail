package com.hhnail.web.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class HColumn {

	//
	private String tableSchema;
	// 所属表名称
	private String tableName;
	// 字段名称
	private String columnName;
	// 是否可为空
	@TableField(value = "IS_NULLABLE")
	private String nullable;
	// 数据类型
	private String dataType;
	// 键类型
	private String columnKey;
	// 字段描述
	private String columnComment;
	// 顺序位置
	private Integer ordinalPosition;


}
