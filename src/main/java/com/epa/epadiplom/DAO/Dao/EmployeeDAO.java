package com.epa.epadiplom.DAO.Dao;

import com.epa.epadiplom.entities.*;

import java.sql.Connection;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findIdList();
    List<Employee> findIdByPriv(int priv);
    List<Employee> findIDByDep(long idDep);
    Employee findMaxIdEmp(Employee employee);
    List<Employee> findAllInList();
    Employee findById(long id);
    void update(Employee employee);
    void create(Employee employee);
    void delete(long id);
//    void infoOfEmployee (long idEMPLOYEE, Connection c, int privilege);

}
