package com.epa.epadiplom.DAO.Dao;

import com.epa.epadiplom.entities.Event;
import java.util.List;

public interface EventDAO {
    public Event findMaxId(Event event);
    public Event findById(long id);
    public List<Event> findAll();
    public Event update(Event dto);
    public Event create(Event dto);
    public void delete(long id);
}
