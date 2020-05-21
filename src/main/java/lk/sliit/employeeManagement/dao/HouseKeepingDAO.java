package lk.sliit.employeeManagement.dao;

import lk.sliit.employeeManagement.entity.HouseKeeping;
import org.springframework.data.repository.CrudRepository;

public interface HouseKeepingDAO extends CrudRepository<HouseKeeping,String> {
}
