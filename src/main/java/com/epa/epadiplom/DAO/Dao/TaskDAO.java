package com.epa.epadiplom.DAO.Dao;

import com.epa.epadiplom.entities.Contact;
import com.epa.epadiplom.entities.Task;
import java.util.List;

public interface TaskDAO {
    public Task findMaxIdTask(Task task);
    public Task findById(long id);
    public List<Task> findAll();
    public Task update(Task dto);
    public Task create(Task dto);
    public void delete(long id);
}
