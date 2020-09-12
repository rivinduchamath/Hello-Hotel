package lk.sliit.hotelManagement.dao.hrDAO;


import lk.sliit.hotelManagement.entity.hr.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentDAO extends CrudRepository<Department,Integer> {
}
