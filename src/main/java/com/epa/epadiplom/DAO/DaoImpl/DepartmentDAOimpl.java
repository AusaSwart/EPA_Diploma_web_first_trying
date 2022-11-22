package com.epa.epadiplom.DAO.DaoImpl;

import com.epa.epadiplom.DAO.Dao.DepartmentDAO;
import com.epa.epadiplom.entities.Department;
import com.epa.epadiplom.mapper.DepartmentMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentDAOimpl implements DepartmentDAO {

    public final JdbcTemplate jdbcTemplate;

    private static final String GET_ONE = "SELECT id, name_dep FROM department WHERE id=?";
    private static final String DELETE = "DELETE FROM department WHERE id = ?";
    private static final String UPDATE = "UPDATE department SET name_dep = ? WHERE id = ?";
    private static final String INSERT = "INSERT INTO department (name_dep) VALUES (?)";
    private static final String GET_ONE_BY_ONE = "SELECT * FROM department ORDER BY id";

    public DepartmentDAOimpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public Department findById(long id) {
        return jdbcTemplate.queryForObject(GET_ONE, new DepartmentMapper(), id);
    }
    public List<Department> findAll() {
        return jdbcTemplate.query(GET_ONE_BY_ONE, new DepartmentMapper());
    }
    public void update(Department department) {
        jdbcTemplate.update(INSERT, department.getNameDep());
    }
    public void create(Department department) {
        jdbcTemplate.update(UPDATE, department.getNameDep(), department.getId());
    }
    public void delete(long id) {
        jdbcTemplate.update(DELETE, id);
    }
}
