package com.epa.epadiplom.DAO.DaoImpl;

import com.epa.epadiplom.DAO.Dao.LoginDAO;
import com.epa.epadiplom.entities.Login;
import com.epa.epadiplom.mapper.LoginMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LoginDAOimpl implements LoginDAO {

    public final JdbcTemplate jdbcTemplate;
    private static final String GET_ALL = "SELECT * FROM login";
    private static final String GET_ONE = "SELECT id_main_info_login, login_user, password_user " +
            "FROM login WHERE id_main_info_login = ?";
    private static final String DELETE = "DELETE FROM login WHERE id_main_info_login = ?";
    private static final String UPDATE = "UPDATE login SET login_user = ?, " +
            "password_user = ?  WHERE id_main_info_login = ?";
    private static final String INSERT = "INSERT INTO login (login_user, password_user, " +
            " id_main_info_login) VALUES (?, ?, ?)";
    private static final String GET_LOGIN_N_PASSWORD = "SELECT login_user, password_user, id_main_info_login " +
            "FROM login WHERE login_user = ? AND password_user = ? ";
    private static final String GET_LOGIN = "SELECT login_user FROM login WHERE login_user = ?";
    public LoginDAOimpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public Login findById(long id) {
        return jdbcTemplate.queryForObject(GET_ONE, new LoginMapper(), id);
    }
    public Login checkPassLog(String loginUser, String passwordUser) {
        return jdbcTemplate.queryForObject(GET_LOGIN_N_PASSWORD, new LoginMapper(), loginUser, passwordUser);
    }
    public Login checkLogin(String loginUser) {
        return jdbcTemplate.queryForObject(GET_LOGIN, new LoginMapper(), loginUser);
    }
    public List<Login> findAll() {
        return jdbcTemplate.query(GET_ALL, new LoginMapper());
    }
    public void update(Login login) {
        jdbcTemplate.update(UPDATE, login.getLoginUser(), login.getPasswordUser(), login.getId());
    }
    public void create(Login login) {
        jdbcTemplate.update(INSERT, login.getLoginUser(), login.getPasswordUser(), login.getId());
    }
    public void delete(long id) {
        jdbcTemplate.update(DELETE, id);
    }
}
