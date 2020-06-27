package lk.sliit.employeeManagement.dao;

import lk.sliit.employeeManagement.entity.Attendance;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface AttendanceDAO extends CrudRepository<Attendance,String> {
    Iterable<Attendance> findAttendanceByDateEquals(Date date);
}
