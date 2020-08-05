package lk.sliit.hotelManagement.dao.hrDAO;

import lk.sliit.hotelManagement.entity.hr.Attendance;
import org.springframework.data.repository.CrudRepository;


public interface AttendanceDAO extends CrudRepository<Attendance,String> {

}
