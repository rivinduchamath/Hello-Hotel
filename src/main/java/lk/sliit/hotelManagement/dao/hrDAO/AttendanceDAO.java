package lk.sliit.hotelManagement.dao.hrDAO;

import lk.sliit.hotelManagement.entity.hr.Attendance;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;


public interface AttendanceDAO extends CrudRepository<Attendance,Integer> {

    Iterable<Attendance> findAttendanceByDateEquals(Date date);

    Attendance findTopByOrderByAttendanceIdDesc();
}
