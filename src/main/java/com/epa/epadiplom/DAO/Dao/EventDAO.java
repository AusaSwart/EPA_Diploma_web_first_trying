package com.epa.epadiplom.DAO.Dao;

import com.epa.epadiplom.entities.Event;
import java.util.List;

public interface EventDAO {
    Event findMaxId(Event event);
    Event findById(long id);
    List<Event> findAll();
    void update(Event event);
    void create(Event event);
    void delete(long id);
}
