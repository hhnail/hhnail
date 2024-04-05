package com.hhnail.web.service;


import com.hhnail.web.bean.SensorsUser;

import java.util.List;
import java.util.Map;

/**
 *
 */
public interface ISensorsUserService {


    // SELECT id,first_id,second_id  FROM horizon_production_2.users LIMIT 10;
    List<SensorsUser> getSensorsUser(Map<String,Object> page);

    int insertSensorsUserList(List<SensorsUser> users);

    void truncateSensorsUser(Map<String, Object> param);

    String getNewUpdateTime(Map<String, Object> param);

    void insertOrUpdateSensorsUser(SensorsUser sensorsUser);
}

