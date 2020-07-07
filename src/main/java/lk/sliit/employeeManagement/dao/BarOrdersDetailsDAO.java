package lk.sliit.employeeManagement.dao;

import lk.sliit.employeeManagement.entity.barManage.BarOrderDetails;
import org.springframework.data.repository.CrudRepository;

public interface BarOrdersDetailsDAO extends CrudRepository<BarOrderDetails,String> {
}
