package com.epa.epadiplom.DAO.Dao;

import com.epa.epadiplom.entities.JobEmployee;

import java.util.List;

public interface JobEmployeeDAO {
    public List<JobEmployee> findByIdEmp (long id_employee);
    public JobEmployee findComplicatedReqFJ(long id_employee);
    public JobEmployee findById(long id_employee);
    public List<JobEmployee> findAll();
    public JobEmployee update(JobEmployee dto);
    public JobEmployee create(JobEmployee dto);
    public void deleteByEntitie(JobEmployee dto);
    public void delete(long id);
}
