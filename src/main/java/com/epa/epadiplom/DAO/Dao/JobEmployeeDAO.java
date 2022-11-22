package com.epa.epadiplom.DAO.Dao;

import com.epa.epadiplom.entities.JobEmployee;
import com.epa.epadiplom.entities.JobTitle;

import java.util.List;

public interface JobEmployeeDAO {
    List<JobEmployee> findByIdEmp (long id_employee);
    List<JobTitle> findComplicatedReqFJ(long id_employee);
    JobEmployee findById(long id_employee);
    List<JobEmployee> findAll();
    void update(JobEmployee jobEmployee);
    void create(JobEmployee jobEmployee);
    void delete(long id);
}
