package com.epa.epadiplom.mapper;

import com.epa.epadiplom.entities.Contact;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactMapper implements RowMapper<Contact> {
    public Contact mapRow(ResultSet resultSet, int i) throws SQLException {
        Contact contact = new Contact();
        contact.setId(resultSet.getLong("id_main_info_contact"));
        contact.setLocationStreet(resultSet.getString("location_street"));
        contact.setWorkNumber(resultSet.getLong("work_number"));
        contact.setPersonalNumber(resultSet.getLong("personal_number"));
        contact.setMail(resultSet.getString("mail"));
        return contact;
    }
}
