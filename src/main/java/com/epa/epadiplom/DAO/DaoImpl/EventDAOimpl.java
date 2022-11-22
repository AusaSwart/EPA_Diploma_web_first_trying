package com.epa.epadiplom.DAO.DaoImpl;

import com.epa.epadiplom.DAO.Dao.EventDAO;
import com.epa.epadiplom.entities.Event;
import com.epa.epadiplom.mapper.EventMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EventDAOimpl implements EventDAO {

    public final JdbcTemplate jdbcTemplate;

    private static final String GET_ONE = "SELECT id, type_of_event, comment_fe, date_of_event" +
            " FROM event WHERE id=?";
    private static final String GET_ALL = "SELECT * FROM event";
    private static final String DELETE = "DELETE FROM event WHERE id = ?";
    private static final String UPDATE = "UPDATE event SET type_of_event = ?," +
            " comment_fe = ?, date_of_event = ? WHERE id = ?";
    private static final String INSERT = "INSERT INTO event (type_of_event, comment_fe, date_of_event)" +
            " VALUES (?, ?, ?)";
    private static final String GET_LAST_VALUE = "SELECT MAX(id) FROM event";

    public EventDAOimpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public Event findMaxId(Event event) {
        return  jdbcTemplate.queryForObject(GET_LAST_VALUE, new EventMapper());
    }
    public Event findById(long id) {
        return jdbcTemplate.queryForObject(GET_ONE, new EventMapper(), id);
    }
    public List<Event> findAll() {
        return jdbcTemplate.query(GET_ALL, new EventMapper());
    }
    public void update(Event event) {
        jdbcTemplate.update(UPDATE, event.getTypeOfEvent(),event.getCommentFE(),
                event.getDateOfEvent(), event.getId());
    }
    public void create(Event event) {
        jdbcTemplate.update(INSERT, event.getTypeOfEvent(),event.getCommentFE(),
                event.getDateOfEvent());
    }
    public void delete(long id) {
        jdbcTemplate.update(DELETE, id);
    }
}
