package lk.sliit.hotelManagement.dao.manageSystem;


import lk.sliit.hotelManagement.entity.manager.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDAO extends CrudRepository<Employee,Integer> {
    Employee findByUserIdAndPassword(int idNo, String password);
}
