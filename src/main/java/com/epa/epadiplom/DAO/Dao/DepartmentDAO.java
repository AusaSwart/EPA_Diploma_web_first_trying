package com.epa.epadiplom.DAO.Dao;

import com.epa.epadiplom.entities.Department;

import java.util.List;

public interface DepartmentDAO {

    Department findById(long id);
    List<Department> findAll();
    void update(Department department);
    void create(Department department);
    void delete(long id);

}
