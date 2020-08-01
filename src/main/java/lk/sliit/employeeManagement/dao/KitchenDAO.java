package lk.sliit.employeeManagement.dao;


import lk.sliit.employeeManagement.entity.kitchen.FoodItem;
import org.springframework.data.repository.CrudRepository;

public interface KitchenDAO extends CrudRepository<FoodItem,String> {
}
