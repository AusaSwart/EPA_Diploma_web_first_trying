package com.epa.epadiplom.mapper;

import org.springframework.jdbc.core.RowMapper;
import com.epa.epadiplom.entities.Task;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskMapper implements RowMapper<Task> {
    public Task mapRow(ResultSet resultSet, int i) throws SQLException {
        Task task = new Task();
        task.setId(resultSet.getLong("id"));
        task.setDateTask(resultSet.getDate("date_task"));
        task.setNameOfTask(resultSet.getString("name_of_task"));
        return task;
    }
}
