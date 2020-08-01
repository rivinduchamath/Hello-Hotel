package lk.sliit.employeeManagement.dao;


import lk.sliit.employeeManagement.entity.hr.Department;
import org.springframework.data.repository.CrudRepository;

public interface HumanResourceDAO extends CrudRepository<Department,String> {
}
