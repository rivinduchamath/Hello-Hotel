package lk.sliit.employeeManagement.dao.hrDAO;

import lk.sliit.employeeManagement.entity.hr.Attendance;
import org.springframework.data.repository.CrudRepository;


public interface AttendanceDAO extends CrudRepository<Attendance,String> {

}
