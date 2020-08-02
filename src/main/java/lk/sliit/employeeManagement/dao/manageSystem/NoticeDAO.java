package lk.sliit.employeeManagement.dao.manageSystem;


import lk.sliit.employeeManagement.entity.manager.Notice;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface NoticeDAO extends CrudRepository<Notice,String> {

    Notice findTopByOrderByNoticeIdDesc();

    Iterable<Notice> findAllByDateBetweenOrderByDateDesc(Date dt, Date todaydate);


}
