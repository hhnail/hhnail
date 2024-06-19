package com.hhnail.web.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author phv
 * CDP QA 用户表
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@TableName("yunbi_common_user")
public class YunbiCommonUser {

    private Long id; // 自增主键
    private String userId; // 用户id
    private String accountId; // 第三方账号id
    private String accountNumber; // daas用户accountId
    private String accountName; // 第三方账号名称
    private Byte accountType; // 第三方账号类型: 0 = 普通账号, 1 = 附属账号
    private String nickname; // 用户昵称
    private String mail; // 用户邮箱
    private String phone; // 用户电话
    private String description; // 描述信息
    private String version; // 扩展版本字段，做灰度控制使用
    private Date gmtCreate; // 创建时间
    private Date gmtModified; // 最新修改时间
    private Byte grayVersion; // 灰度切换级别, 详见GrayVersion
    private String parentAccountName; // 阿里云主账号登录名

}
