//package com.epa.epadiplom.DAO.DaoImpl;
//
//
//import com.epa.epadiplom.DAO.Dao.LoginDAO;
//import com.epa.epadiplom.entities.Login;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//@Repository
//public class LoginDAOimpl implements LoginDAO {
//
//    @Autowired
//    public JdbcTemplate jdbcTemplate;
//
//    public LoginDAO(Connection connection) {
//        super(connection);
//    }
//    private static final String GET_ONE = "SELECT id_main_info_login, login_user, password_user " +
//            "FROM login WHERE id_main_info_login = ?";
//    private static final String DELETE = "DELETE FROM login WHERE id_main_info_login = ?";
//    private static final String UPDATE = "UPDATE login SET login_user = ?, " +
//            "password_user = ?  WHERE id_main_info_login = ?";
//    private static final String INSERT = "INSERT INTO login (login_user, password_user, " +
//            " id_main_info_login) VALUES (?, ?, ?)";
//    private static final String GET_LOGIN_N_PASSWORD = "SELECT login_user, password_user, id_main_info_login " +
//            "FROM login WHERE login_user = ? AND password_user = ? ";
//    private static final String GET_LOGIN = "SELECT login_user FROM login WHERE login_user = ?";
//
//    public Login findById(long id) {
//        Login login = new Login();
//        try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE);){
//            statement.setLong(1, id);
//            ResultSet rs = statement.executeQuery();
//            while(rs.next()){
//                login.setId(rs.getLong("id_main_info_login"));
//                login.setLoginUser(rs.getString("login_user"));
//                login.setPasswordUser(rs.getString("password_user"));
//            }
//        }catch (SQLException e){
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//        return login;
//    }
//
//    public Login checkPassLog(String loginUser, String passwordUser) {
//        Login login = new Login();
//        try(PreparedStatement statement = this.connection.prepareStatement(GET_LOGIN_N_PASSWORD);){
//            statement.setString(1, loginUser);
//            statement.setString(2, passwordUser);
//            ResultSet rs = statement.executeQuery();
//            while(rs.next()){
//                login.setId(rs.getLong("id_main_info_login"));
//                login.setLoginUser(rs.getString("login_user"));
//                login.setPasswordUser(rs.getString("password_user"));
//            }
//        }catch (SQLException e){
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//        return login;
//    }
//
//    public Login checkLogin(String loginUser) {
//        Login login = new Login();
//        try(PreparedStatement statement = this.connection.prepareStatement(GET_LOGIN);){
//            statement.setString(1, loginUser);
//            ResultSet rs = statement.executeQuery();
//            while(rs.next()){
//                login.setLoginUser(rs.getString("login_user"));
//            }
//        }catch (SQLException e){
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//        return login;
//    }
//
//    public List<Login> findAll() {
//        return null;
//    }
//
//    public Login update(Login dto) {
//        Login login = null;
//        try{
//            this.connection.setAutoCommit(false);
//        }catch(SQLException e){
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//        try(PreparedStatement statement = this.connection.prepareStatement(UPDATE);){
//            statement.setString(1, dto.getLoginUser());
//            statement.setString(2, dto.getPasswordUser());
//            statement.setLong(3, dto.getId());
//            statement.execute();
//            this.connection.commit();            //
//            login = this.findById(dto.getId());  // разобраться в этом куске
//        }catch(SQLException e){
//            try{
//                this.connection.rollback();
//            }catch (SQLException sqle){
//                e.printStackTrace();
//                throw new RuntimeException(sqle);
//            }
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//        return login;
//    }
//
//    public Login create(Login dto) {
//        Login login = null;
//        try{
//            this.connection.setAutoCommit(false);
//        }catch(SQLException e){
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//        try(PreparedStatement statement = this.connection.prepareStatement(INSERT);){
//            statement.setString(1, dto.getLoginUser());
//            statement.setString(2, dto.getPasswordUser());
//            statement.setLong(3, dto.getId());
//            statement.execute();
//            this.connection.commit();
//            login = this.findById(dto.getId());
//        }catch(SQLException e){
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//        return login;
//    }
//
//    public void delete(long id) {
//        try{
//            this.connection.setAutoCommit(false);
//        }catch(SQLException e){
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//        try(PreparedStatement statement = this.connection.prepareStatement(DELETE);){
//            statement.setLong(1, id);
//            statement.executeUpdate();
//            this.connection.commit();
//        }catch (SQLException e){
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//    }
//}
