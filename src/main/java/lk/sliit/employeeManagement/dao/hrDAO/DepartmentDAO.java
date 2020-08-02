package lk.sliit.employeeManagement.dao.hrDAO;


import lk.sliit.employeeManagement.entity.hr.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentDAO extends CrudRepository<Department,String> {
}
