package com.epa.epadiplom.DAO.Dao;

import com.epa.epadiplom.entities.JobTitle;

import java.util.List;

public interface JobTitleDAO {

    public List<JobTitle> findAll();
    public JobTitle findById(long id);
    public JobTitle update(JobTitle dto);
    public JobTitle create(JobTitle dto);
    public void delete(long id);

}
