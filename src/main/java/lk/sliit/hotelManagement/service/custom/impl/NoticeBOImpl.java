package lk.sliit.hotelManagement.service.custom.impl;

import lk.sliit.hotelManagement.dao.manageSystem.NoticeDAO;
import lk.sliit.hotelManagement.dto.manager.NoticeDTO;
import lk.sliit.hotelManagement.entity.manager.Notice;
import lk.sliit.hotelManagement.service.custom.NoticeBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class NoticeBOImpl implements NoticeBO {


    @Autowired
    NoticeDAO noticeDAO;

    @Override
    public void saveNotice(NoticeDTO noticeDTO) {
        noticeDAO.save(new Notice(
                noticeDTO.getNoticeId(),
                noticeDTO.getTitle(),
                noticeDTO.getDescription(),
                noticeDTO.getDate()
        ));
    }

    @Override
    @Transactional(readOnly = true)
    public List<NoticeDTO> findAll() {
        Iterable<Notice> all = noticeDAO.findAll();
        List<NoticeDTO> dtos = new ArrayList<>();
        for (Notice a: all) {
            dtos.add(new NoticeDTO(
                  a.getNoticeId(),
                  a.getTitle(),
                  a.getDescription(),
                  a.getDate()
            ));
        }
        return dtos;
    }

    @Override
    public void deleteNotice(String notId) {
      noticeDAO.delete(notId);
    }

    @Override
    public NoticeDTO findId() {
       Notice a = noticeDAO.findTopByOrderByNoticeIdDesc();
      try {
          return new NoticeDTO(
                  a.getNoticeId()
          );
      }catch (NullPointerException e){
          System.out.println("No Notice Fond");
      }
    return null;
    }

    @Override
    public NoticeDTO findNoticeById(String noticeId) {
        Notice notice = noticeDAO.findOne (noticeId);
        return new NoticeDTO (notice.getNoticeId (),
                notice.getTitle(),
                notice.getDescription(),
                notice.getDate()
        );



}


}
