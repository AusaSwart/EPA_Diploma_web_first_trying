package com.epa.epadiplom.DAO.Dao;

import com.epa.epadiplom.entities.EmployeeTask;

import java.util.List;

public interface EmployeeTaskDAO {

    public EmployeeTask findComplicatedReq(long id);
    public EmployeeTask findById(long id);
    public List<EmployeeTask> findAll();
    public EmployeeTask update(EmployeeTask dto);
    public EmployeeTask create(EmployeeTask dto);
    public void delete(long id);
}
