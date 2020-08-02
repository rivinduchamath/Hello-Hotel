package lk.sliit.employeeManagement.dao.kitchenDAO;


import lk.sliit.employeeManagement.entity.kitchen.FoodItem;
import org.springframework.data.repository.CrudRepository;

public interface KitchenDAO extends CrudRepository<FoodItem,String> {
}
