package lk.sliit.hotelManagement.dao.hrDAO;

import lk.sliit.hotelManagement.entity.hr.Salary;
import lk.sliit.hotelManagement.entity.restaurant.counterTableReservation.CounterTableReservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface SalaryDAO extends CrudRepository<Salary,Integer> {
    Salary findTopByOrderBySalaryIdDesc();

    Iterable<Salary> findAllByStateAndDateEquals(boolean c, Date date);


    @Query(value = "from Salary t where (t.otHours between :endTime and :startTimes)  and t.date = :date")
    Iterable<Salary> getAllBetweenDates(@Param("startTimes") Date startTimes, @Param("endTime")Date endTime, @Param("date")Date date);


    // void findSalariesByDateMonthAndEmployeeIDEquals(int m, int employeeID);
}