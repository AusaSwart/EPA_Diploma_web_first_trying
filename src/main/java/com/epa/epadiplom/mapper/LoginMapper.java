package com.epa.epadiplom.mapper;

import com.epa.epadiplom.entities.Login;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginMapper implements RowMapper<Login> {

    public Login mapRow(ResultSet resultSet, int i) throws SQLException {
        Login login = new Login();
        login.setId(resultSet.getLong("id_main_info_login"));
        login.setLoginUser(resultSet.getString("login_user"));
        login.setPasswordUser(resultSet.getString("password_user"));
        return login;
    }
}
