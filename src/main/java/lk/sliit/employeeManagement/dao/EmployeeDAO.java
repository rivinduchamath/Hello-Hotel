package lk.sliit.employeeManagement.dao;

import lk.sliit.employeeManagement.dto.EmployeeDTO;
import lk.sliit.employeeManagement.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDAO extends CrudRepository<Employee,String> {
    Employee findByIdNoAndPassword(String idNo, String password);
}
