package lk.sliit.hotelManagement.dao.hrDAO;

import lk.sliit.hotelManagement.entity.hr.Attendance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;


public interface AttendanceDAO extends CrudRepository<Attendance,Integer> {

    Iterable<Attendance> findAttendanceByDateEquals(Date date);

    Attendance findTopByOrderByAttendanceIdDesc();

    @Query("SELECT SUM(m.overtimeHours) FROM Attendance m where (m.date between  :date and :date1) and m.employeeID.userId = :userId")
    double findAllByDateBetweenAndEmployeeID_UserIdEquals(@Param("date")Date date, @Param("date1")Date date1, @Param("userId")int userId);

}
