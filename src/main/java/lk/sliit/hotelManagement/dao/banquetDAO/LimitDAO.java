package lk.sliit.hotelManagement.dao.banquetDAO;


import lk.sliit.hotelManagement.entity.banquet.OrderLimit;
import org.springframework.data.repository.CrudRepository;

public interface LimitDAO extends CrudRepository<OrderLimit,Integer> {
}
