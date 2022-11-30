package com.epa.epadiplom.service;

import com.epa.epadiplom.DAO.Dao.JobTitleDAO;
import com.epa.epadiplom.entities.JobTitle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    public final JobTitleDAO jobTitleDAO;
    public UserServiceImpl(JobTitleDAO jobTitleDAO) {
        this.jobTitleDAO = jobTitleDAO;
    }
    @Override
    public List<JobTitle> findAll() {
        return jobTitleDAO.findAll();
    }
    @Override
    public JobTitle findById(long id) {
        return null;
    }
    @Override
    public void update(JobTitle jobTitle) {

    }
    @Override
    public void create(JobTitle jobTitle) {

    }
    @Override
    public void delete(long id) {

    }
}
