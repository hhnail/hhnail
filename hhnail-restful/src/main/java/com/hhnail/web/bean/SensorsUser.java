package com.hhnail.web.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author phv
 * 神策用户
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@TableName("sensors_user")
public class SensorsUser {
    // 神策数据清单：https://scdata.hzrobam.com/horizon/meta-table/user-entity/users/list/basic-property?page=1&pageSize=100&totalCount=69&project=production&product=sbp_family
    private String id;
    private String deviceIdList;
    private String identityDistinctId;
    private String identityAnonymousId;
    private Date birthday;
    private Boolean isMember;
    private String nickName;
    private String sex;
    private String district;
    // 手机号码
    private String phoneNumber;
    private String address;
    private Date firstVisitTime;
    private Integer boundNumber;
    private Integer favoritesNumber;
    private Date memberDate;
    private String secondId;
    private BigDecimal updateTime;
    private String firstId;
    private Date createTime;
    private String userTagZj30tfxcszddnrlm;
    private String userTagSxzjsfsygcp;
    private String userTagZj30tllyhzncszddcplm;
    private Integer userTagAge;
    private String userTagZj30tsccpdsl;
    private String userTagCurrentMonth;
    private String userTagZj30tzxcpdsl;
    private Integer userTagBoundNumber;
    private String userTagZj30tljwzydscfz;
    private String userTagBdcplx;
    private String userTagZj30tljkcxxscfz;
    private String userTagZj30tljcpllscfz;
    private String userTagLjfxcs;
    private Integer userTagBirthdayYear;
    private String userTagGender;
    private String userTagSfwsxx;
    private String userTagZj30tsscs;
    private String userTagZjycssnr;
    private String userTagZj30tllgzyycszddcplm;
    private String userTagZjycfwxcxdsj;
    private String userTagZj30tdbcszddcplm;
    private String userTagZj30tllcszddcpmc;
    private String userTagZj30tllcszddcplm;
    private String userTagZjycfwxcxjjts;
    private String userTagZj30tzxcszddcplm;
    private String userTagZj30tzxcszddcpmc;
    private String userTagZj30tsccszddcplm;
    private String userTagLjfwts;
    private String userTagZj30tfwts;
    private String userTagZj3160tfwts;
    private String userTagCpsczcsj;
    private String userTagZj30tfwsdph;
    private String userTagSczcjjts;
    private String userTagZj30tpjfwdsjjgt;
    private String userTagZcdwsf;
    private String userTagJ30tfwmkph;
    private String userTagZcdwcs;
    private String userTagZcdwsf1;
    private String userTagZcdwcs1;
    private String userTagZj30tdbcszddcpmc;
    private String userTagScfwxcxjjts;
    private String userTagScfwxcxdsj;
    private String userTagLjkcxxsl;
    private String userTagLjkcxxscfz;
    private String userTagZj30tllcszddkc;
    private String userTagZj30tllcszddcp;
    private String userTagZj30tllsjzcdcp;
    private String userTagGq30tsfsygcp;
    private String userTagSxzjsfllwz;
    private String userTagZj30tydcszddwzhwzlmxzwd;
    private String userTagGq30tsfllwz;
    private Integer userTagZj30tygbnxcpgn; // 最近30天用过帮你选产品功能
    private Integer userTagCjsygbnxcp; // 曾经使用过帮你选产品
    private Integer userTagGq30tsfsycpdbgn; // 过去30天是否使用产品对比功能
    private Integer userTagSxzjsfsygcpdbgn; // 上线至今是否使用过产品对比功能
    private Integer userTagCjyggzzc; // 曾经用过故障自查
    private Integer userTagCjsygyhzn; // 曾经使用过养护指南
    private Integer userTagGq30tsfxxgkc; // 过去30天是否学习过课程
    private Integer userTagSxzjsfxxgkc; // 上线至今是否学习过课程

}
