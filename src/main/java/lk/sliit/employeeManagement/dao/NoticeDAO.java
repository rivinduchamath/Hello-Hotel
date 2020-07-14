package lk.sliit.employeeManagement.dao;


import lk.sliit.employeeManagement.entity.Notice;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface NoticeDAO extends CrudRepository<Notice,String> {

    Notice findTopByOrderByNoticeIdDesc();

    Iterable<Notice> findAllByDateBetweenOrderByDateDesc(Date dt, Date todaydate);


}
