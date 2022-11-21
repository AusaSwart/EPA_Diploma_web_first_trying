package com.epa.epadiplom.DAO.Dao;

import com.epa.epadiplom.entities.LogStatement;

import java.util.List;

public interface LogStatementDAO {

    public LogStatement findComplicatedReqLS(long id);
    public LogStatement getIDLS( java.sql.Date date, long idEMPLOYEE);
    public LogStatement findByIdForApprove(long id_approver);
    public LogStatement findById(long id_approver);
    public LogStatement updateApprove(LogStatement dto);
    public List<LogStatement> findAll();
    public LogStatement update(LogStatement dto);
    public LogStatement create(LogStatement dto);
    public void delete(long id);
}
