package com.epa.epadiplom.DAO.DaoImpl;

import com.epa.epadiplom.DAO.Dao.*;
import com.epa.epadiplom.entities.*;
import com.epa.epadiplom.mapper.EmployeeMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOimpl implements EmployeeDAO {

    public final JdbcTemplate jdbcTemplate;

    private static final String GET_ONE = "SELECT id, privilege, id_dep " +
            "FROM employee WHERE id=?";
    private static final String GET_ONE_BY_ONE = "SELECT * FROM employee ORDER BY id";
    private static final String DELETE = "DELETE FROM employee WHERE id = ?";
    private static final String UPDATE = "UPDATE employee SET privilege = ?, " +
            "id_dep = ? WHERE id = ?";
    private static final String INSERT = "INSERT INTO employee (privilege, id_dep)" +
            "VALUES (?, ?)";
    private static final String GET_LAST_VALUE = "SELECT MAX(id) FROM employee";
    private static final String GET_BY_DEP = "SELECT id FROM employee WHERE id_dep = ?";
    private static final String GET_BY_PRIV = "SELECT id FROM employee WHERE privilege = ?";
    private static final String GET_ID = "SELECT id FROM employee ORDER BY id";

    public EmployeeDAOimpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Employee> findIdList() {
        return jdbcTemplate.query(GET_ID, new EmployeeMapper());
    }
    public List<Employee> findIdByPriv(int priv) {
        return jdbcTemplate.query(GET_BY_PRIV, new EmployeeMapper(), priv);
    }
    public List<Employee> findIDByDep(long idDep) {
        return jdbcTemplate.query(GET_BY_DEP, new EmployeeMapper(), idDep);
    }
    public Employee findMaxIdEmp(Employee employee) {
        return jdbcTemplate.queryForObject(GET_LAST_VALUE, new EmployeeMapper());
    }
    public List<Employee> findAllInList() {
        return jdbcTemplate.query(GET_ONE_BY_ONE, new EmployeeMapper());
    }
    public Employee findById(long id) {
        return jdbcTemplate.queryForObject(GET_ONE, new EmployeeMapper(), id);
    }
    public void update(Employee employee) {
        jdbcTemplate.update(UPDATE, employee.getPrivilege(), employee.getIdDep(), employee.getId());
    }
    public void create(Employee employee) {
        jdbcTemplate.update(INSERT, employee.getPrivilege(), employee.getIdDep());
    }
    public void delete(long id) {
        jdbcTemplate.update(DELETE, id);
    }

//    public void infoOfEmployee (long idEMPLOYEE, Connection c,int privilege) {
//        System.out.println("|-----------------------------------------------------|");
//        System.out.println();
//        EmployeeDAO employeeDAO = new EmployeeDAO(c);
//        Employee employee = employeeDAO.findById(idEMPLOYEE);
//        DepartmentDAO departmentDAO = new DepartmentDAO(c);
//        Department department = departmentDAO.findById(employee.getIdDep());
//        MainInfoDAO mainInfoDAO = new MainInfoDAO(c);
//        MainInfo mainInfo = mainInfoDAO.findById(idEMPLOYEE);
//        ContactDAO contactDAO = new ContactDAO(c);
//        Contact contact = contactDAO.findById(idEMPLOYEE);
//        JobEmployeeDAO jobEmployeeDAO = new JobEmployeeDAO(c);
//        JobEmployee jobEmployee = jobEmployeeDAO.findComplicatedReqFJ(idEMPLOYEE);
//        LoginDAO loginDAO = new LoginDAO(c);
//        Login login = loginDAO.findById(idEMPLOYEE);
//        System.out.println("___ Main Info ___");
//        System.out.println("_Employee " + mainInfo.getFirstName() +
//                " " + mainInfo.getMiddleName() + " " +
//                mainInfo.getLastName() + ",");
//        System.out.println(" №" + idEMPLOYEE);
//        System.out.println(" Privileges stage: " + employee.getPrivilege());
//        System.out.println();
//        System.out.println("_Name of department: "
//                + department.getNameDep());
//        jobEmployee.getJobTitles().forEach(System.out::println);
//        System.out.println();
//        System.out.println("_Location____");
//        System.out.println("   Work place: " + mainInfo.getCabinetOffice());
//        System.out.println("   Street: " + contact.getLocationStreet());
//        System.out.println();
//        System.out.println("_Contact____");
//        System.out.println("   Work number: " + contact.getWorkNumber());
//        System.out.println("   Personal number: +" + contact.getPersonalNumber());
//        System.out.println("   Mail: " + contact.getMail());
//        System.out.println("_Date of entry: " + mainInfo.getEntryD());
//        System.out.println("_Birth day: " + mainInfo.getBirthD());
//        System.out.println();
//        if(privilege == 1) {
//            System.out.println("_Login____");
//            System.out.println("   Login: " + login.getLoginUser());
//            System.out.println("   Password: " + login.getPasswordUser());
//            System.out.println();
//        }
//    }
}
