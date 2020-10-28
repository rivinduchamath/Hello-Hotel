package lk.sliit.hotelManagement.dao.hrDAO;

import lk.sliit.hotelManagement.entity.hr.Salary;
import lk.sliit.hotelManagement.entity.manager.Employee;
import lk.sliit.hotelManagement.entity.restaurant.counterTableReservation.CounterTableReservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.Set;

public interface SalaryDAO extends CrudRepository<Salary,Integer> {
    Salary findTopByOrderBySalaryIdDesc();

    Iterable<Salary> findAllByStateAndDateEquals(boolean c, Date date);
    @Query(value = "select t.employeeID from Salary t where t.state = :state ")
    Set<Employee> findAllByStateEquals(@Param("state")boolean state);



    @Query(value = "from Salary t where (t.otHours between :endTime and :startTimes)  and t.date = :date")
    Iterable<Salary> getAllBetweenDates(@Param("startTimes") Date startTimes, @Param("endTime")Date endTime, @Param("date")Date date);

    @Query("SELECT SUM(m.otHours) FROM Salary m where  m.employeeID.userId = :userId")
    double findAllByDateBetweenAndEmployeeID_UserIdEquals(@Param("userId")int userId);

    @Query("SELECT SUM(m.hours) FROM Salary m where  m.employeeID.userId = :userId")
    double findAllByDateBetweenAndEmployeeID_UserIdEqual(@Param("userId")int userId);



    // void findSalariesByDateMonthAndEmployeeIDEquals(int m, int employeeID);
}