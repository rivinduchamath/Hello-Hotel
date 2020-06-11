package lk.sliit.employeeManagement.service.custom;

import lk.sliit.employeeManagement.dto.NoticeDTO;
import lk.sliit.employeeManagement.service.SuperBO;

import java.util.List;

public interface NoticeBO extends SuperBO {

    void saveNotice(NoticeDTO noticeDTO);

    List<NoticeDTO> findAll();

    void deleteNotice(String notId);

    NoticeDTO findId();

    NoticeDTO findNoticeById(String noticeId);
}
