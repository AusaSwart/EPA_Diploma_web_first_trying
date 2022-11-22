package com.epa.epadiplom.DAO.DaoImpl;

import com.epa.epadiplom.DAO.Dao.ContactDAO;
import com.epa.epadiplom.entities.Contact;
import com.epa.epadiplom.mapper.ContactMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactDAOimpl implements ContactDAO {

    public final JdbcTemplate jdbcTemplate;

    private static final String GET_ONE = "SELECT id_main_info_contact, location_street, work_number, personal_number, " +
            "mail FROM contact WHERE id_main_info_contact=?";
    private static final String DELETE = "DELETE FROM contact WHERE id_main_info_contact = ?";
    private static final String UPDATE = "UPDATE contact SET location_street = ?, work_number = ?," +
            " personal_number = ?, mail = ?  WHERE id_main_info_contact = ?";
    private static final String INSERT = "INSERT INTO contact (location_street, work_number, personal_number, " +
            "mail, id_main_info_contact) VALUES (?, ?, ?, ?, ?)";
    private static final String GET_ONE_BY_ONE = "SELECT * FROM contact ORDER BY id_main_info_contact";
    private static final String GET_MAIL = "SELECT mail FROM contact WHERE mail = ?";

    public ContactDAOimpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public Contact checkMail(String mail) {
        return jdbcTemplate.queryForObject(GET_MAIL, new ContactMapper(), mail);
    }
    public Contact findById(long id) {
        return jdbcTemplate.queryForObject(GET_ONE, new ContactMapper(), id);
    }
    public List<Contact> findAll() {
        return jdbcTemplate.query(GET_ONE_BY_ONE, new ContactMapper());
    }
    public void update(Contact contact) {
        jdbcTemplate.update(UPDATE, contact.getLocationStreet(), contact.getWorkNumber(),
                contact.getPersonalNumber(),contact.getMail(), contact.getId());
    }
    public void create(Contact contact) {
        jdbcTemplate.update(INSERT, contact.getLocationStreet(), contact.getWorkNumber(),
                contact.getPersonalNumber(),contact.getMail(), contact.getId());
    }
    public void delete(long id) {
        jdbcTemplate.update(DELETE, id);
    }
}
