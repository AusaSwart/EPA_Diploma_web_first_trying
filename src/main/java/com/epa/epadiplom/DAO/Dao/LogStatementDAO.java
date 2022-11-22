package com.epa.epadiplom.DAO.Dao;

import com.epa.epadiplom.entities.LogStatement;

import java.util.List;

public interface LogStatementDAO {

    List<LogStatement> findComplicatedReqLS(long id);
    LogStatement getIDLS( java.sql.Date date, long idEMPLOYEE);
    List<LogStatement> findByIdForApprove(long id_approver);
    LogStatement findById(long id_approver);
    void updateApprove(LogStatement logStatement);
    List<LogStatement> findAll();
    void update(LogStatement logStatement);
    void create(LogStatement logStatement);
    void delete(long id);
}
