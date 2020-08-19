package lk.sliit.hotelManagement.dao.beverageDAO;

import lk.sliit.hotelManagement.entity.barManage.BarOrders;
import org.springframework.data.repository.CrudRepository;

public interface BarOrdersDAO extends CrudRepository<BarOrders,String> {
    BarOrders findTopByOrderByOrderIdDesc();
}
