package lk.sliit.hotelManagement.dao.hrDAO;

import lk.sliit.hotelManagement.entity.hr.Salary;
import org.springframework.data.repository.CrudRepository;

public interface SalaryDAO extends CrudRepository<Salary,String> {
}
