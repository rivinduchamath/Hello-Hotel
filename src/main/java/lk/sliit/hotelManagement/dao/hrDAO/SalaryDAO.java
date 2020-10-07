package lk.sliit.hotelManagement.dao.hrDAO;

import lk.sliit.hotelManagement.entity.hr.Salary;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface SalaryDAO extends CrudRepository<Salary,Integer> {
    Salary findTopByOrderBySalaryIdDesc();

    Iterable<Salary> findAllByStateEquals(boolean c);

    Iterable<Salary> findAllByDateBetweenAndStateEquals(Date date1,Date date2, boolean b);


    // void findSalariesByDateMonthAndEmployeeIDEquals(int m, int employeeID);
}