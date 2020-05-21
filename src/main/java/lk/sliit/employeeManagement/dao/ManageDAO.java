package lk.sliit.employeeManagement.dao;


import lk.sliit.employeeManagement.entity.Manage;
import org.springframework.data.repository.CrudRepository;

public interface ManageDAO extends CrudRepository<Manage,String> {
}
