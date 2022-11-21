package com.epa.epadiplom.mapper;

import com.epa.epadiplom.entities.JobEmployee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JobEmployeeMapper implements RowMapper<JobEmployee> {

    public JobEmployee mapRow(ResultSet resultSet, int i) throws SQLException {
        JobEmployee jobEmployee = new JobEmployee();
        jobEmployee.setIdEmployee(resultSet.getLong("id_employee"));
        jobEmployee.setIdJobTitle(resultSet.getLong("id_job_title"));
        jobEmployee.setId(resultSet.getLong("id"));
        return jobEmployee;
    }
}
