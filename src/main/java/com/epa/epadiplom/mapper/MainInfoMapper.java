package com.epa.epadiplom.mapper;

import com.epa.epadiplom.entities.MainInfo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MainInfoMapper implements RowMapper<MainInfo> {
    public MainInfo mapRow(ResultSet resultSet, int i) throws SQLException {
        MainInfo mainInfo = new MainInfo();
        mainInfo.setId(resultSet.getLong("id_main_info"));
        mainInfo.setFirstName(resultSet.getString("first_name"));
        mainInfo.setMiddleName(resultSet.getString("middle_name"));
        mainInfo.setLastName(resultSet.getString("last_name"));
        mainInfo.setCabinetOffice(resultSet.getString("cabinet_office"));
        mainInfo.setBirthD(resultSet.getDate("birth_d"));
        mainInfo.setEntryD(resultSet.getDate("entry_d"));
        return mainInfo;
    }
}
