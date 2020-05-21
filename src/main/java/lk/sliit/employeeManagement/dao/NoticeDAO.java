package lk.sliit.employeeManagement.dao;


import lk.sliit.employeeManagement.entity.Notice;
import org.springframework.data.repository.CrudRepository;

public interface NoticeDAO extends CrudRepository<Notice,String> {

    Notice findTopByOrderByNoticeIdDesc();
}
