package com.epa.epadiplom.mapper;

import com.epa.epadiplom.entities.JobTitle;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JobTitleMapper implements RowMapper<JobTitle> {
    public JobTitle mapRow(ResultSet resultSet, int i) throws SQLException {
        JobTitle jobTitle = new JobTitle();
        jobTitle.setId(resultSet.getLong("id"));
        jobTitle.setJobTitleName(resultSet.getString("job_title_name"));
        return jobTitle;
    }
}
