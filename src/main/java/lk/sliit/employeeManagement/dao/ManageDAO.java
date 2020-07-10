package lk.sliit.employeeManagement.dao;


import lk.sliit.employeeManagement.entity.manager.ManageUser;
import org.springframework.data.repository.CrudRepository;

public interface ManageDAO extends CrudRepository<ManageUser,String> {
}
