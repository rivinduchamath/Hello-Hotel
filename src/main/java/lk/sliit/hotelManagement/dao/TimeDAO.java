package lk.sliit.hotelManagement.dao;

import lk.sliit.hotelManagement.entity.TimeCheck;
import org.springframework.data.repository.CrudRepository;

public interface TimeDAO extends CrudRepository<TimeCheck, String> {


}
