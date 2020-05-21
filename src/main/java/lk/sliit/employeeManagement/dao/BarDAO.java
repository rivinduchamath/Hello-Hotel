package lk.sliit.employeeManagement.dao;

import lk.sliit.employeeManagement.entity.Bar;
import org.springframework.data.repository.CrudRepository;

public interface BarDAO extends CrudRepository<Bar,String> {
}
