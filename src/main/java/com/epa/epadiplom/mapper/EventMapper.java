package com.epa.epadiplom.mapper;

import com.epa.epadiplom.entities.Event;
import org.springframework.jdbc.core.RowMapper;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EventMapper  implements RowMapper<Event> {
    public Event mapRow(ResultSet resultSet, int i) throws SQLException {
        Event event = new Event();
        event.setId(resultSet.getLong("id"));
        event.setTypeOfEvent(resultSet.getString("type_of_event"));
        event.setCommentFE(resultSet.getString("comment_fe"));
        event.setDateOfEvent(resultSet.getDate("date_of_event"));
        return event;
    }
}
