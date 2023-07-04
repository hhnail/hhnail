package com.hhnail.web.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * @author phv
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("wechat_follower")
@ToString
public class WeChatFollower {

    @TableId(type = IdType.AUTO, value = "id")
    private Long id;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private Date updateTime;

    private int subscribe;
    private String openid;
    private String nickname;
    private int sex;
    @TableField(exist = false)
    private String language;
    private String city;
    private String province;
    private String country;
    private String headImgUrl;
    private long subscribeTime;
    private String unionid;
    private String remark;
    private int groupId;
    @TableField(exist = false)
    private List<String> tagIdList;
    @TableField(value = "tag_id_list")
    private String tagIdListStr;
    private String subscribeScene;
    private int qrScene;
    private String qrSceneStr;
}
