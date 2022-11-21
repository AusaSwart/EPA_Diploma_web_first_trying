package com.epa.epadiplom.DAO.Dao;

import com.epa.epadiplom.entities.*;

import java.sql.Connection;

import java.util.List;

public interface EmployeeDAO {

    public List<Long> findIdList();
    public List<Long> findIdByPriv(int priv);
    public List<Long> findIDByDep(long idDep);
    public Employee findMaxIdEmp(Employee employee);
    public List<Employee> findAllInList();
    public Employee findById(long id);
    public List<Employee> findAll();
    public Employee update(Employee dto);
    public Employee create(Employee dto);
    public void delete(long id);
    public void infoOfEmployee (long idEMPLOYEE, Connection c, int privilege);

}
