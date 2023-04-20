package com.hhnail.web.service;

import java.util.List;

public interface DingDingService {

    /**
     * 获取钉钉请求token
     * @return
     */
    String getDingDingApiToken();

    /**
     * 获取某部门下的子部门
     * @param deptId
     * @return
     */
    List<Integer> getSubDepartmentIds(String deptId);

}
