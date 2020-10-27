package lk.sliit.hotelManagement.dao.hrDAO;

import lk.sliit.hotelManagement.entity.hr.SalarySettings;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface SalarySettingsDAO extends CrudRepository<SalarySettings,Integer> {

    Iterable<SalarySettings> findAllByOrderByIdDesc();

    SalarySettings findTopByOrderByIdDesc();
}
