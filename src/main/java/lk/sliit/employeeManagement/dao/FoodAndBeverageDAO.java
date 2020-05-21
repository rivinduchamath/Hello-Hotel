package lk.sliit.employeeManagement.dao;

import lk.sliit.employeeManagement.entity.FoodAndBeverage;
import org.springframework.data.repository.CrudRepository;

public interface FoodAndBeverageDAO extends CrudRepository<FoodAndBeverage,String> {
}
