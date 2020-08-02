package lk.sliit.employeeManagement.dao.hrDAO;

import lk.sliit.employeeManagement.entity.hr.Accounts;
import org.springframework.data.repository.CrudRepository;

public interface AccountsDAO extends CrudRepository<Accounts,String> {
}
