package com.epa.epadiplom.DAO.DaoImpl;

import com.epa.epadiplom.DAO.Dao.JobEmployeeDAO;
import com.epa.epadiplom.entities.JobEmployee;
import com.epa.epadiplom.entities.JobTitle;
import com.epa.epadiplom.mapper.JobEmployeeMapper;
import com.epa.epadiplom.mapper.JobTitleMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class JobEmployeeDAOimpl implements JobEmployeeDAO {

    public final JdbcTemplate jdbcTemplate;

    private static final String GET_ONE = "SELECT id_employee, id_job_title FROM job_employee WHERE id_employee=?";
    private static final String GET_ALL = "SELECT * FROM job_employee";
    private static final String DELETE = "DELETE FROM job_employee WHERE id = ?";
    private static final String UPDATE = "UPDATE job_employee SET id_job_title = ? WHERE id_employee = ? AND id = ?";
    private static final String INSERT = "INSERT INTO job_employee (id_job_title, id_employee) VALUES (?, ?)";
    private static final String GET_COMPLICATED = "SELECT jt.job_title_name FROM public.job_employee je JOIN" +
            " public.job_title jt ON jt.id = je.id_job_title WHERE je.id_employee = ?";
    private static final String GET_ONE_EM = "SELECT id_employee, id_job_title, id FROM job_employee WHERE " +
            "id_employee = ?";

    public JobEmployeeDAOimpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<JobEmployee> findByIdEmp (long id_employee) {
        return jdbcTemplate.query(GET_ONE_EM, new JobEmployeeMapper(), id_employee);
    }
    public List<JobTitle> findComplicatedReqFJ(long id_employee) {
        JobTitle jobTitle = new JobTitle();
        //JobEmployee jobEmployee = new JobEmployee();
        return jdbcTemplate.query(GET_COMPLICATED, new JobTitleMapper(),
                jobTitle.getJobTitleName(), id_employee);
    }
    public JobEmployee findById(long id_employee) {
        return jdbcTemplate.queryForObject(GET_ONE, new JobEmployeeMapper(), id_employee);
    }
    public List<JobEmployee> findAll() {
        return jdbcTemplate.query(GET_ALL, new JobEmployeeMapper());
    }
    public void update(JobEmployee jobEmployee) {
      jdbcTemplate.update(UPDATE, jobEmployee.getIdJobTitle(), jobEmployee.getIdEmployee(),
              jobEmployee.getId());
    }
    public void create(JobEmployee jobEmployee) {
        jdbcTemplate.update(INSERT, jobEmployee.getIdJobTitle(), jobEmployee.getIdEmployee());
    }
    public void delete(long id) {
        jdbcTemplate.update(DELETE, id);
    }

}
