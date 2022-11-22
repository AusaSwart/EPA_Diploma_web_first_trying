package com.epa.epadiplom.DAO.Dao;

import com.epa.epadiplom.entities.Task;
import java.util.List;

public interface TaskDAO {
    Task findMaxIdTask(Task task);
    Task findById(long id);
    List<Task> findAll();
    void update(Task task);
    void create(Task task);
    void delete(long id);
}
