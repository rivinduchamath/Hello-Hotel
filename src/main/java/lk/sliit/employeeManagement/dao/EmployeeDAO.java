package lk.sliit.employeeManagement.dao;


import lk.sliit.employeeManagement.entity.manager.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDAO extends CrudRepository<Employee,String> {
    Employee findByUserIdAndPassword(String idNo, String password);
}
