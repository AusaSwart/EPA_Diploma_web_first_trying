package com.epa.epadiplom.mapper;

import com.epa.epadiplom.entities.Department;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentMapper {

    public Department mapRow(ResultSet resultSet, int i) throws SQLException {
        Department department = new Department();
        department.setId(resultSet.getLong("id"));
        department.setNameDep(resultSet.getString("name_dep"));
        return department;
    }
}
