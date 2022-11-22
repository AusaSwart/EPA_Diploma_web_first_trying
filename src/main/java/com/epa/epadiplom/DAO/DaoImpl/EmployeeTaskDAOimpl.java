package com.epa.epadiplom.DAO.DaoImpl;

import com.epa.epadiplom.DAO.Dao.EmployeeTaskDAO;
import com.epa.epadiplom.entities.EmployeeTask;
import com.epa.epadiplom.entities.Task;
import com.epa.epadiplom.mapper.EmployeeTaskMapper;
import com.epa.epadiplom.mapper.TaskMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeTaskDAOimpl implements EmployeeTaskDAO {

    public final JdbcTemplate jdbcTemplate;

    private static final String GET_ONE = "SELECT id_executor, id_employee, id_task," +
            " comment_te FROM emp_task WHERE id_executor=?";
    private static final String GET_ALL = "SELECT * FROM emp_task";
    private static final String CHECK = "SELECT * FROM emp_task WHERE id_executor=? " +
            "AND id_task = ?";
    private static final String DELETE = "DELETE FROM emp_task WHERE id_executor = ?";
    private static final String UPDATE = "UPDATE emp_task SET id_employee = ?, id_task = ?, " +
            "comment_te = ? WHERE id_executor = ?";
    private static final String INSERT = "INSERT INTO emp_task (id_executor, id_employee, id_task," +
            " comment_te) VALUES (?, ?, ?, ?)";
    private static final String GET_COMPLICATED = "SELECT et.id_executor, et.comment_te," +
            " et.id_employee, et.id_task, t.date_task FROM public.emp_task et JOIN " +
            "public.task t ON et.id_task = t.id WHERE id_executor = ? ";

    public EmployeeTaskDAOimpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Task> findComplicatedReq(long id) {
        EmployeeTask employeeTask = new EmployeeTask();
        Task task = new Task();
        return jdbcTemplate.query(GET_COMPLICATED, new TaskMapper(), new EmployeeTaskMapper(),
                employeeTask.getId(), employeeTask.getCommentTE(), employeeTask.getIdEmployee(),
                employeeTask.getIdTask(), task.getDateTask(), id);
    }
    public EmployeeTask findById(long id) {
        return jdbcTemplate.queryForObject(GET_ONE, new EmployeeTaskMapper(), id);
    }
    public List<EmployeeTask> findAll() {
        return jdbcTemplate.query(GET_ALL, new EmployeeTaskMapper());
    }
    public void update(EmployeeTask employeeTask) {
        jdbcTemplate.update(UPDATE, employeeTask.getIdEmployee(), employeeTask.getIdTask(),
                employeeTask.getCommentTE(), employeeTask.getId());
    }
    public void create(EmployeeTask employeeTask) {
        jdbcTemplate.update(INSERT, employeeTask.getId(), employeeTask.getIdEmployee(),
                employeeTask.getIdTask(), employeeTask.getCommentTE());
    }
    public void delete(long id) {
        jdbcTemplate.update(DELETE, id);
    }
}
