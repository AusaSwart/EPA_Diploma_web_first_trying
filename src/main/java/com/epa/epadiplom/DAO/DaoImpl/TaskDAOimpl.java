package com.epa.epadiplom.DAO.DaoImpl;

import com.epa.epadiplom.entities.Task;
import com.epa.epadiplom.DAO.Dao.TaskDAO;
import com.epa.epadiplom.mapper.TaskMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TaskDAOimpl implements TaskDAO {

    public final JdbcTemplate jdbcTemplate;
    private static final String GET_ALL = "SELECT * FROM task";
    private static final String GET_ONE = "SELECT id, date_task, name_of_task FROM task WHERE id = ?";
    private static final String DELETE = "DELETE FROM task WHERE id = ?";
    private static final String UPDATE = "UPDATE task SET date_task = ?, name_of_task = ? WHERE id = ?";
    private static final String INSERT = "INSERT INTO task (date_task, name_of_task) VALUES (?, ?)";
    private static final String GET_LAST_VALUE = "SELECT MAX(id) FROM task";

    public TaskDAOimpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public Task findMaxIdTask(Task task) {
        jdbcTemplate.query(GET_LAST_VALUE, new TaskMapper(), task.getId());
        return task;
    }
    public Task findById(long id) {
        return jdbcTemplate.queryForObject(GET_ONE, new TaskMapper());
    }
    public List<Task> findAll() {
        return jdbcTemplate.query(GET_ALL, new TaskMapper());
    }
    public void update(Task task) {
        jdbcTemplate.update(UPDATE, task.getDateTask(), task.getNameOfTask(), task.getId());
    }
    public void create(Task task) {
        jdbcTemplate.update(INSERT, task.getDateTask(), task.getNameOfTask());
    }
    public void delete(long id) {
       jdbcTemplate.update(DELETE, id);
    }

}
