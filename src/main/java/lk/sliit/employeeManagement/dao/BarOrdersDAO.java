package lk.sliit.employeeManagement.dao;

import lk.sliit.employeeManagement.entity.barManage.BarOrders;
import org.springframework.data.repository.CrudRepository;

public interface BarOrdersDAO extends CrudRepository<BarOrders,String> {
    BarOrders findTopByOrderByOrderIdDesc();
}
