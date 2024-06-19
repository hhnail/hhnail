package com.hhnail.web.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hhnail.web.bean.YunbiCommonUser;
import com.hhnail.web.enums.JdbcDriverEnum;
import com.hhnail.web.mapper.ResultSetMapper;
import com.hhnail.web.service.IJdbcCdpQaService;
import com.hhnail.web.util.VvEncryptUtil;
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
public class JdbcCdpQaServiceImpl implements ResultSetMapper<YunbiCommonUser>, IJdbcCdpQaService {

    private static String key = "a2b39c6b-5f52-48";

    private static String jdbcUrl = "luTd3fC6iQ5WymjtRIB1mUbCHVjOAlo+m/pVT4XCNK5lGKu0+yEsg1Ky0j7ROGH6wRVKCv+f7HlzsIZSqO+oldUZ6Mv9PyfcrnzM89OXt8Y=";
    private static String jdbcUser = "j3wokqh/X+QgAnjOoYFUIA==";
    private static String jdbcPwd = "Anxg0jnVGYhiuwKe/NZz6DnJ3kgO/e8TtlvbEqyRDhs=";

    // @Autowired
    // SensorsEventMapper sensorsEventMapper;

    @Override
    public YunbiCommonUser mapRow(ResultSet rs) throws SQLException {
        YunbiCommonUser user = new YunbiCommonUser();
        // user.setUserId(rs.getLong("user_id"));
        // user.setEventId(rs.getLong("event_id"));
        // user.setEvent(rs.getString("event"));
        // user.setTime(rs.getTimestamp("time"));
        // user.setOs(rs.getString("os"));
        // user.setBrand(rs.getString("brand"));
        // user.setPageSource(rs.getString("page_source"));
        // user.setProductName(rs.getString("product_name"));
        // user.setProductCategory(rs.getString("product_category"));
        // user.setDistinctId(rs.getString("distinct_id"));
        return user;
    }


    @Override
    public List<YunbiCommonUser> getList(Map<String, Object> param) {

        String sql = "SELECT "
                + " user_id,"
                + " event_id,"
                + " event,"
                + " time,"
                + " $os as os,"
                + " $brand as brand,"
                + " page_source,"
                + " product_name,"
                + " product_category,"
                + " distinct_id"
                + " FROM horizon_production_2.events e"
                + " WHERE 1=1"
                + " and e.event = 'ProductDetailExp'"
                + (param.containsKey("time") ? " and time >= '" + param.get("time") + "'" : "")
                + (param.containsKey("order_by") ? " order by " + param.get("order_by") : "")
                + " LIMIT " + param.get("size");

        System.out.println("===sql:" + sql);

        return VvJdbcUtils.executeQuery(
                JdbcDriverEnum.MYSQL,
                jdbcUrl, jdbcUser, jdbcPwd, sql,
                new JdbcCdpQaServiceImpl()
        );
    }


    @Override
    public int insertList(List<YunbiCommonUser> list) {
        // return sensorsEventMapper.insertSensorsEventList(list);
        return -1;
    }


    @Override
    public String getNewUpdateTime(Map<String, Object> param) {

        // return sensorsEventMapper.getNewUpdateTime(param);
        return null;
    }

    @Override
    public void insertOrUpdate(YunbiCommonUser obj) {
        // sensorsEventMapper.insertOrUpdateSensorsEvent(sensorsEvent);
    }

    @Override
    public void resetUserPwd(JSONObject param) {

        String user_pass = param.getString("user_pass");
        String user_account = param.getString("user_account");

        String sql = "update quickaudience.yunbi_common_user u"
                + "        inner join quickaudience.yunbi_user_pass p on u.account_name = p.user_account"
                + "        inner join quickaudience.yunbi_organization_member m on m.user_id = u.user_id"
                + "        set"
                + "        p.user_pass = '" + user_pass + "',"
                + "        u.nickname = concat(u.nickname,'(无效)')"
                + "        where 1=1"
                + "        and p.user_account = '" + user_account + "'"
                + "        and length(p.user_account) > 0";
        VvJdbcUtils.executeUpdate(
                JdbcDriverEnum.MYSQL,
                VvEncryptUtil.aes16Decrypt(jdbcUrl, key),
                VvEncryptUtil.aes16Decrypt(jdbcUser, key),
                VvEncryptUtil.aes16Decrypt(jdbcPwd, key),
                sql
        );
    }

}