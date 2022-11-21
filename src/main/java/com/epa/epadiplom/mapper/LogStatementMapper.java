package com.epa.epadiplom.mapper;

import com.epa.epadiplom.entities.LogStatement;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LogStatementMapper implements RowMapper<LogStatement> {
    public LogStatement mapRow(ResultSet resultSet, int i) throws SQLException {
        LogStatement logStatement = new LogStatement();
        logStatement.setId(resultSet.getLong("id"));
        logStatement.setIdApprover(resultSet.getLong("id_approver"));
        logStatement.setIdEmployee(resultSet.getLong("id_employee"));
        logStatement.setCommentLs(resultSet.getString("comment_ls"));
        logStatement.setDaysSum(resultSet.getInt("days_sum"));
        logStatement.setTypeLeave(resultSet.getInt("type_leave"));
        logStatement.setApprove(resultSet.getInt("approve"));
        logStatement.setDateLeave(resultSet.getDate("date_leave"));
        logStatement.setDateOfLs(resultSet.getDate("date_of_ls"));
        return logStatement;
    }
}
