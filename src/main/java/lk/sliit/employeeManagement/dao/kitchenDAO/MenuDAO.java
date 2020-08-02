package lk.sliit.employeeManagement.dao.kitchenDAO;


import lk.sliit.employeeManagement.entity.kitchen.Menu;
import org.springframework.data.repository.CrudRepository;

public interface MenuDAO extends CrudRepository<Menu,String> {
}
