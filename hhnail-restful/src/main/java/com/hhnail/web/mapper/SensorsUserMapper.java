package com.hhnail.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hhnail.web.bean.SensorsUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

// @Repository
@Mapper
public interface SensorsUserMapper extends BaseMapper<SensorsUser> {

    int insertSensorsUserList(@Param("users") List<SensorsUser> users);

    int insertSensorsUser(@Param("user")SensorsUser user);

    void truncateSensorsUser();

    String getNewUpdateTime(Map<String, Object> param);

    void insertOrUpdateSensorsUser(@Param("user")SensorsUser sensorsUser);
}
