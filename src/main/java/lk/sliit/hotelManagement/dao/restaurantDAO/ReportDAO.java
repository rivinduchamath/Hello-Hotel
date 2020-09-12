package lk.sliit.hotelManagement.dao.restaurantDAO;

import lk.sliit.hotelManagement.entity.restaurant.Report;
import org.springframework.data.repository.CrudRepository;

public interface ReportDAO extends CrudRepository<Report,Integer> {
}
