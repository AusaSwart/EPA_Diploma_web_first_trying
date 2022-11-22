package com.epa.epadiplom.DAO.Dao;

import com.epa.epadiplom.entities.JobTitle;

import java.util.List;

public interface JobTitleDAO {

    List<JobTitle> findAll();
    JobTitle findById(long id);
    void update(JobTitle jobTitle);
    void create(JobTitle jobTitle);
    void delete(long id);

}
