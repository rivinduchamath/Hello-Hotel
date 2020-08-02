package lk.sliit.employeeManagement.dao.hrDAO;

import lk.sliit.employeeManagement.entity.hr.Salary;
import org.springframework.data.repository.CrudRepository;

public interface SalaryDAO extends CrudRepository<Salary,String> {
}
