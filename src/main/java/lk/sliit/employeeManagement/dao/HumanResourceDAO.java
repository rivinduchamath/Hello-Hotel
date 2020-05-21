package lk.sliit.employeeManagement.dao;


import lk.sliit.employeeManagement.entity.HumanResource;
import org.springframework.data.repository.CrudRepository;

public interface HumanResourceDAO extends CrudRepository<HumanResource,String> {
}
