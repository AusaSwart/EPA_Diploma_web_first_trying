package com.epa.epadiplom.DAO.Dao;

import com.epa.epadiplom.entities.Department;

import java.util.List;

public interface DepartmentDAO {

    public Department findById(long id);
    public List<Department> findAll();
    public Department update(Department dto);
    public Department create(Department dto);
    public void delete(long id);

}
