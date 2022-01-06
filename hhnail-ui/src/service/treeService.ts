import axios from "axios";
import qs from 'querystring'

export interface HTable {
  tableName: string,
}

export interface HColumn {
  //
  // private String tableSchema;
  // 所属表名称
  // tableName:string,
  // 字段名称
  columnName: string;
  // 是否可为空
  // nullable:string,
  // 数据类型
  dataType: string,
  // 键类型
  // columnKey:string;
  // 字段描述
  columnComment: string,
  // 顺序位置
  // ordinalPosition:number,
}

export function queryTable() {
  return axios.post(`/api01/queryTable`)
}

export function queryColumn(tableName: string) {
  return axios.post(`/api01/queryColumn`, qs.stringify({tableName}))
}
