package com.epa.epadiplom.DAO.DaoImpl;

import com.epa.epadiplom.DAO.Dao.JobTitleDAO;
import com.epa.epadiplom.entities.JobTitle;
import com.epa.epadiplom.mapper.JobTitleMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JobTitleDAOimpl implements JobTitleDAO {

    public final JdbcTemplate jdbcTemplate;

    private static final String GET_ONE = "SELECT id, job_title_name FROM job_title WHERE id=?";
    private static final String DELETE = "DELETE FROM job_title WHERE id = ?";
    private static final String UPDATE = "UPDATE job_title SET job_title_name = ?  WHERE id = ?";
    private static final String INSERT = "INSERT INTO job_title (job_title_name) VALUES (?)";
    private static final String GET_NAMES = "SELECT job_title_name, id FROM public.job_title " +
            "ORDER BY id";

    public JobTitleDAOimpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<JobTitle> findAll() {
        return jdbcTemplate.query(GET_NAMES, new JobTitleMapper());
    }
    public JobTitle findById(long id) {
        return jdbcTemplate.queryForObject(GET_ONE, new JobTitleMapper(), id);
    }
    public void update(JobTitle jobTitle) {
      jdbcTemplate.update(UPDATE, jobTitle.getJobTitleName(), jobTitle.getId());
    }
    public void create(JobTitle jobTitle) {
        jdbcTemplate.update(INSERT, jobTitle.getJobTitleName());
    }
    public void delete(long id) {
        jdbcTemplate.update(DELETE, id);
    }
}
