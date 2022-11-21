package com.epa.epadiplom.mapper;

import com.epa.epadiplom.entities.EmployeeTask;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeTaskMapper  implements RowMapper<EmployeeTask> {
    public EmployeeTask mapRow(ResultSet resultSet, int i) throws SQLException {
        EmployeeTask employeeTask = new EmployeeTask();
        employeeTask.setId(resultSet.getLong("id_executor"));
        employeeTask.setIdEmployee(resultSet.getLong("id_employee"));
        employeeTask.setIdTask(resultSet.getLong("id_task"));
        employeeTask.setCommentTE(resultSet.getString("comment_te"));
        return employeeTask;
    }
}
