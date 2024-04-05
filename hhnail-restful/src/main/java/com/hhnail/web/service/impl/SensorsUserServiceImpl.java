package com.hhnail.web.service.impl;

import com.hhnail.web.bean.SensorsUser;
import com.hhnail.web.mapper.ResultSetMapper;
import com.hhnail.web.mapper.SensorsUserMapper;
import com.hhnail.web.service.ISensorsUserService;
import com.hhnail.web.util.VvJdbcUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class SensorsUserServiceImpl implements ISensorsUserService, ResultSetMapper<SensorsUser> {

    private static String jdbcDriverName = "org.apache.hive.jdbc.HiveDriver";
    private static String jdbcUrl = "jdbc:hive2://172.16.150.99:8416";
    private static String jdbcUser = "peixun6";
    private static String jdbcPwd = "#K-M9DA28cpn2yGPm2iKhAHHLYfvnFcjBex";

    @Autowired
    SensorsUserMapper sensorsUserMapper;


    @Override
    public SensorsUser mapRow(ResultSet rs) throws SQLException {
        SensorsUser user = new SensorsUser();
        user.setId(rs.getString("id"));
        user.setUpdateTime(rs.getBigDecimal("update_time"));
        user.setFirstId(rs.getString("first_id"));
        user.setSecondId(rs.getString("second_id"));
        user.setPhoneNumber(rs.getString("phone_number"));
        user.setUserTagZj30tygbnxcpgn(rs.getInt("user_tag_zj30tygbnxcpgn"));
        user.setUserTagCjsygbnxcp(rs.getInt("user_tag_cjsygbnxcp"));
        user.setUserTagCjyggzzc(rs.getInt("user_tag_cjyggzzc"));
        user.setUserTagCjsygyhzn(rs.getInt("user_tag_cjsygyhzn"));
        user.setUserTagGq30tsfsycpdbgn(rs.getInt("user_tag_gq30tsfsycpdbgn"));
        user.setUserTagSxzjsfsygcpdbgn(rs.getInt("user_tag_sxzjsfsygcpdbgn"));
        user.setUserTagGq30tsfxxgkc(rs.getInt("user_tag_gq30tsfxxgkc"));
        user.setUserTagSxzjsfxxgkc(rs.getInt("user_tag_sxzjsfxxgkc"));
        return user;
    }


    // SELECT id,first_id,second_id  FROM horizon_production_2.users LIMIT 10;
    @Override
    public List<SensorsUser> getSensorsUser(Map<String, Object> param) {
        String sql = "SELECT"
                + " second_id,$update_time as update_time,first_id,id,$identity_distinct_id as identity_distinct_id,"
                + " birthday,is_member,nick_name,sex,district,phone_number,address,$first_visit_time as first_visit_time,"
                + " bound_number,favorites_number,member_date,user_tag_zj30tfxcszddnrlm,"
                + " user_tag_sxzjsfsygcp,user_tag_zj30tllyhzncszddcplm,user_tag_age,user_tag_zj30tsccpdsl,user_tag_current_month,"
                + " user_tag_zj30tzxcpdsl,user_tag_bound_number,user_tag_zj30tljwzydscfz,user_tag_bdcplx,user_tag_zj30tljkcxxscfz,"
                + " user_tag_zj30tljcpllscfz,user_tag_ljfxcs,user_tag_birthday_year,user_tag_gender,user_tag_sfwsxx,user_tag_zj30tsscs,"
                + " user_tag_zjycssnr,user_tag_zj30tllgzyycszddcplm,user_tag_zjycfwxcxdsj,user_tag_zj30tdbcszddcplm,user_tag_zj30tllcszddcpmc,"
                + " user_tag_zj30tllcszddcplm,user_tag_zjycfwxcxjjts,user_tag_zj30tzxcszddcplm,user_tag_zj30tzxcszddcpmc,"
                + " user_tag_zj30tsccszddcplm,user_tag_ljfwts,user_tag_zj30tfwts,user_tag_zj3160tfwts,user_tag_cpsczcsj,user_tag_zj30tfwsdph,"
                + " user_tag_sczcjjts,user_tag_zj30tpjfwdsjjgt,user_tag_zcdwsf,user_tag_j30tfwmkph,user_tag_zcdwcs,user_tag_zcdwsf1,user_tag_zcdwcs1,"
                + " user_tag_zj30tdbcszddcpmc,user_tag_scfwxcxjjts,user_tag_scfwxcxdsj,user_tag_ljkcxxsl,user_tag_ljkcxxscfz,user_tag_zj30tllcszddkc,"
                + " user_tag_zj30tllcszddcp,user_tag_zj30tllsjzcdcp,user_tag_gq30tsfsygcp,user_tag_sxzjsfllwz,user_tag_zj30tydcszddwzhwzlmxzwd,"
                + " user_tag_gq30tsfllwz,"
                + " user_tag_sxzjsfsygcpdbgn, user_tag_gq30tsfsycpdbgn,"
                + " user_tag_sxzjsfxxgkc, user_tag_gq30tsfxxgkc,"
                + " user_tag_zj30tygbnxcpgn, user_tag_cjsygbnxcp,"
                + " user_tag_cjyggzzc, user_tag_cjsygyhzn"
                + " FROM horizon_production_2.users"
                + " WHERE 1=1"
                + (param.containsKey("id") ? " and id > " + param.get("id") : "")
                + (param.containsKey("update_time") ? " and $update_time > " + param.get("update_time") : "")
                + (param.containsKey("order_by") ? " order by " + param.get("order_by") : "")
                + " LIMIT " + param.get("size");
        System.out.println("===sql:" + sql);
        return VvJdbcUtils.executeQuery(
                jdbcUrl, jdbcUser, jdbcPwd,
                sql, new SensorsUserServiceImpl()
        );
    }

    @Override
    public int insertSensorsUserList(List<SensorsUser> users) {
        return sensorsUserMapper.insertSensorsUserList(users);
    }

    @Override
    public void truncateSensorsUser(Map<String, Object> param) {
        sensorsUserMapper.truncateSensorsUser();
    }

    @Override
    public String getNewUpdateTime(Map<String, Object> param) {
        return sensorsUserMapper.getNewUpdateTime(param);
    }

    @Override
    public void insertOrUpdateSensorsUser(SensorsUser sensorsUser) {
        sensorsUserMapper.insertOrUpdateSensorsUser(sensorsUser);
    }
}
