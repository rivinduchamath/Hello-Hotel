package lk.sliit.employeeManagement.dao;


import lk.sliit.employeeManagement.entity.Kitchen;
import org.springframework.data.repository.CrudRepository;

public interface KitchenDAO extends CrudRepository<Kitchen,String> {
}
