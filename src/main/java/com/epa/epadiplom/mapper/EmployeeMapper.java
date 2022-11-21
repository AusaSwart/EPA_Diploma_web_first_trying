package com.epa.epadiplom.mapper;

import com.epa.epadiplom.entities.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper  implements RowMapper<Employee> {
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getLong("id"));
        employee.setPrivilege(resultSet.getInt("privilege"));
        employee.setIdDep(resultSet.getLong("id_dep"));
        return employee;
    }
}
