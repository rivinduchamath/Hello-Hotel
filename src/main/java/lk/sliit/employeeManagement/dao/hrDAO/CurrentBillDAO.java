package lk.sliit.employeeManagement.dao.hrDAO;


import lk.sliit.employeeManagement.entity.hr.CurrentBill;
import org.springframework.data.repository.CrudRepository;

public interface CurrentBillDAO extends CrudRepository<CurrentBill,String> {
}
