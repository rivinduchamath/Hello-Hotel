package lk.sliit.employeeManagement.dao.restaurantDAO;

import lk.sliit.employeeManagement.entity.restaurant.Report;
import org.springframework.data.repository.CrudRepository;

public interface ReportDAO extends CrudRepository<Report,String> {
}
