package com.epa.epadiplom.DAO.Dao;

import com.epa.epadiplom.entities.EmployeeTask;
import com.epa.epadiplom.entities.Task;

import java.util.List;

public interface EmployeeTaskDAO {

    List<Task> findComplicatedReq(long id);
    EmployeeTask findById(long id);
    List<EmployeeTask> findAll();
    void update(EmployeeTask employeeTask);
    void create(EmployeeTask employeeTask);
    void delete(long id);
}
