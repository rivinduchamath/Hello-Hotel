package lk.sliit.hotelManagement.dao.hrDAO;

import lk.sliit.hotelManagement.entity.hr.Accounts;
import org.springframework.data.repository.CrudRepository;

public interface AccountsDAO extends CrudRepository<Accounts,Integer> {
    Accounts findTopByOrderByAccountIdDesc();
}
