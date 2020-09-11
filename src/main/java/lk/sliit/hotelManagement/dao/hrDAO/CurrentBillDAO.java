package lk.sliit.hotelManagement.dao.hrDAO;


import lk.sliit.hotelManagement.entity.hr.CurrentBill;
import org.springframework.data.repository.CrudRepository;


public interface CurrentBillDAO extends CrudRepository<CurrentBill,Integer> {
    CurrentBill findTopByOrderByBillIdDesc();

}
