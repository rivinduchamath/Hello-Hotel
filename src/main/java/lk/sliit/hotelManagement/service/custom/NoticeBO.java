package lk.sliit.hotelManagement.service.custom;

import lk.sliit.hotelManagement.dto.manager.NoticeDTO;
import lk.sliit.hotelManagement.service.SuperBO;

import java.util.List;

public interface NoticeBO extends SuperBO {

    void saveNotice(NoticeDTO noticeDTO);

    List<NoticeDTO> findAll();

    void deleteNotice(int notId);

    NoticeDTO findId();

    NoticeDTO findNoticeById(int noticeId);


}
