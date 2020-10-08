package lk.sliit.hotelManagement.dao.hrDAO;

import lk.sliit.hotelManagement.entity.hr.Salary;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface SalaryDAO extends CrudRepository<Salary,Integer> {
    Salary findTopByOrderBySalaryIdDesc();

    Iterable<Salary> findAllByStateAndDateEquals(boolean c, Date date);




    // void findSalariesByDateMonthAndEmployeeIDEquals(int m, int employeeID);
}