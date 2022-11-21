//package com.epa.epadiplom.DAO.DaoImpl;
//
//import com.epa.epadiplom.DAO.Dao.DepartmentDAO;
//import com.epa.epadiplom.entities.Department;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class DepartmentDAOimpl implements DepartmentDAO {
//
//    @Autowired
//    public JdbcTemplate jdbcTemplate;
//
//    public DepartmentDAO(Connection connection) {
//        super(connection);
//    }
//    private static final String GET_ONE = "SELECT id, name_dep FROM department WHERE id=?";
//    private static final String DELETE = "DELETE FROM department WHERE id = ?";
//    private static final String UPDATE = "UPDATE department SET name_dep = ? WHERE id = ?";
//    private static final String INSERT = "INSERT INTO department (name_dep) VALUES (?)";
//    private static final String GET_ONE_BY_ONE = "SELECT * FROM department ORDER BY id";
//
//    public Department findById(long id) {
//        Department department = new Department();
//        try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE);){
//            statement.setLong(1, id);
//            ResultSet rs = statement.executeQuery();
//            while(rs.next()){
//                department.setId(rs.getLong("id"));
//                department.setNameDep(rs.getString("name_dep"));
//
//            }
//        }catch (SQLException e){
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//        return department;
//    }
//
//    public List<Department> findAll() {
//        List<Department> departments = new ArrayList<>();
//        try (PreparedStatement statement = this.connection.prepareStatement(GET_ONE_BY_ONE);) {
//            ResultSet rs = statement.executeQuery();
//            while (rs.next()) {
//                Department department = new Department();
//                department.setId(rs.getLong("id"));
//                department.setNameDep(rs.getString("name_dep"));
//                departments.add(department);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//        return departments;
//    }
//
//    public Department update(Department dto) {
//        Department department = null;
//        try{
//            this.connection.setAutoCommit(false);
//        }catch(SQLException e){
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//        try(PreparedStatement statement = this.connection.prepareStatement(UPDATE);){
//            statement.setString(1, dto.getNameDep());
//            statement.setLong(2, dto.getId());
//            statement.execute();
//            this.connection.commit();
//            department = this.findById(dto.getId());
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
//        return department;
//    }
//
//    public Department create(Department dto) {
//        Department department = null;
//        try(PreparedStatement statement = this.connection.prepareStatement(INSERT);){
//            statement.setString(1, dto.getNameDep());
//            statement.execute();
//            this.connection.commit();
//            department = this.findById(dto.getId());
//        }catch(SQLException e){
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//        return department;
//    }
//
//    public void delete(long id) {
//        try(PreparedStatement statement = this.connection.prepareStatement(DELETE);){
//            statement.setLong(1, id);
//            statement.execute();
//        }catch (SQLException e){
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//    }
//}
