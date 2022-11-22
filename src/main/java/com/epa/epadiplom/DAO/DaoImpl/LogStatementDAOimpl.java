package com.epa.epadiplom.DAO.DaoImpl;

import com.epa.epadiplom.DAO.Dao.LogStatementDAO;
import com.epa.epadiplom.entities.LogStatement;
import com.epa.epadiplom.entities.Document;
import com.epa.epadiplom.mapper.DocumentMapper;
import com.epa.epadiplom.mapper.LogStatementMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LogStatementDAOimpl implements LogStatementDAO {

    public final JdbcTemplate jdbcTemplate;
    private static final String GET_ONE = "SELECT id, id_approver, id_employee, comment_ls, days_sum, " +
            "type_leave, approve, date_leave, date_of_ls FROM log_statement WHERE id_approver = ?";
    private static final String DELETE = "DELETE FROM log_statement WHERE id = ?";
    private static final String UPDATE = "UPDATE log_statement SET id_approver = ?, id_employee = ?, comment_ls = ?," +
            " days_sum = ?, type_leave = ?, approve = ?, date_leave = ?, date_of_ls = ?  WHERE id = ?";
    private static final String INSERT = "INSERT INTO log_statement (id_approver, id_employee, comment_ls, days_sum, " +
            "type_leave, approve, date_leave, date_of_ls ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_COMPLICATED_LS = " SELECT ls.id, ls.id_approver, ls.id_employee, ls.comment_ls," +
            " ls.days_sum, ls.type_leave, ls.approve, ls.date_leave, ls.date_of_ls, d.body_doc, d.id " +
            "FROM public.log_statement ls JOIN public.document d ON ls.id = d.id_ls WHERE id_approver = ? " +
            "AND approve = 3 ORDER BY ls.id ASC";
    private static final String GET_ONE_APPR = "SELECT id, id_approver, approve FROM log_statement " +
            "WHERE id_approver = ? AND approve = 3 ORDER BY id DESC";
    private static final String UPDATE_APPROVE = "UPDATE log_statement SET approve = ?  WHERE id = ?";
    private static final String GET_ID_FROM_DATE = "SELECT MAX(id) FROM log_statement WHERE" +
            " id_employee = ? AND date_of_ls = ?";
    private static final String GET_ALL = "SELECT * FROM log_statement";
    public LogStatementDAOimpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public LogStatement findById(long id_approver) {
        return jdbcTemplate.queryForObject(GET_ONE, new LogStatementMapper(), id_approver);
    }
    public void updateApprove(LogStatement logStatement) {
        jdbcTemplate.update(UPDATE_APPROVE, logStatement.getApprove(), logStatement.getId());
    }
    public List<LogStatement> findAll() {
        return jdbcTemplate.query(GET_ALL, new LogStatementMapper());
    }
    public void update(LogStatement logStatement) {
        jdbcTemplate.update(UPDATE, logStatement.getIdApprover(), logStatement.getIdEmployee(),
                logStatement.getCommentLs(), logStatement.getDaysSum(), logStatement.getTypeLeave(),
                logStatement.getApprove(), logStatement.getDateLeave(), logStatement.getDateOfLs(),
                logStatement.getId());
    }
    public void create(LogStatement logStatement) {
        jdbcTemplate.update(INSERT, logStatement.getIdApprover(), logStatement.getIdEmployee(),
                logStatement.getCommentLs(), logStatement.getDaysSum(), logStatement.getTypeLeave(),
                logStatement.getApprove(), logStatement.getDateLeave(), logStatement.getDateOfLs());
    }
    public void delete(long id) {
        jdbcTemplate.update(DELETE, id);
    }
    public List<LogStatement> findComplicatedReqLS(long id) {
        LogStatement logStatement = new LogStatement();
        Document document = new Document();
        return jdbcTemplate.query(GET_COMPLICATED_LS, new LogStatementMapper(), new DocumentMapper(),
                logStatement.getIdApprover(), logStatement.getIdEmployee(),
                logStatement.getCommentLs(), logStatement.getDaysSum(),
                logStatement.getTypeLeave(), logStatement.getApprove(),
                logStatement.getDateLeave(), logStatement.getDateOfLs(),
                document.getBodyDoc(), document.getId(), id);
    }
    public LogStatement getIDLS( java.sql.Date date, long idEMPLOYEE) {
        return jdbcTemplate.queryForObject(GET_ID_FROM_DATE, new LogStatementMapper(), date, idEMPLOYEE);
    }
    public List<LogStatement> findByIdForApprove(long id_approver) {
        return jdbcTemplate.query(GET_ONE_APPR, new LogStatementMapper(), id_approver);
    }
}
