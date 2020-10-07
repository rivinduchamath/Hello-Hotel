package lk.sliit.hotelManagement.dao.manageSystemDAO;


import lk.sliit.hotelManagement.entity.manager.Employee;
import lk.sliit.hotelManagement.entity.restaurant.onlineTableReservation.OnlineTableReservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface EmployeeDAO extends CrudRepository<Employee,Integer> {
    Employee findByUserIdAndPassword(int idNo, String password);

    Employee findTopByOrderByUserIdDesc();


}
