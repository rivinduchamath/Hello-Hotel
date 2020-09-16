package lk.sliit.hotelManagement.dao.manageSystemDAO;


import lk.sliit.hotelManagement.entity.manager.Notice;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface NoticeDAO extends CrudRepository<Notice,Integer> {

    Notice findTopByOrderByNoticeIdDesc();

    Iterable<Notice> findAllByDateBetweenOrderByDateDesc(Date dt, Date todaydate);


    Iterable<Notice> findProjectsByDateBetweenOrderByDateDesc(Date todaydate, Date afterOneMonth);


    Iterable<Notice> findAllByOrderByDateDesc();
}
