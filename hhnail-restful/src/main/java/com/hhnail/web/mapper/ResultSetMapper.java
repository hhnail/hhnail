package com.hhnail.web.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @param <T> bean
 */
public interface ResultSetMapper<T> {

    T mapRow(ResultSet rs) throws SQLException;

}