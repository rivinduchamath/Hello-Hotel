package lk.sliit.hotelManagement.controller.noticeController;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.hr.DepartmentDTO;
import lk.sliit.hotelManagement.dto.manager.EmployeeDTO;
import lk.sliit.hotelManagement.dto.manager.NoticeDTO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import lk.sliit.hotelManagement.service.custom.ManageBO;
import lk.sliit.hotelManagement.service.custom.NoticeBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class NoticeController { //notice.jsp For All Notice



    @Autowired
    NoticeBO noticeBO;

    @Autowired
    IndexLoginBO indexLoginBO;
    @Autowired
    ManageBO manageBO;

    @GetMapping("notice")
    public ModelAndView load(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo((SuperController.idNo)));

        ModelAndView mav = new ModelAndView("notice");
        List<NoticeDTO> p = noticeBO.findAll();
        model.addAttribute("loadNoticeTable", p);
        List<DepartmentDTO> p2 = manageBO.findAllDepartment();
        model.addAttribute("loadDepartment", p2);

        return mav;
    }

    @PostMapping("noticeSave")
    public String saveForm(@ModelAttribute NoticeDTO noticeDTO) {
        try {
            NoticeDTO noticeDTO1 = noticeBO.findId();
            NoticeDTO noticeDTO2 = null;
            try {
                noticeDTO2 = noticeBO.findNoticeById(noticeDTO.getNoticeId());
            }catch (NullPointerException d){
                int maxId = (noticeDTO1.getNoticeId());
                if (noticeDTO.getNoticeId()==(maxId)) {
                    noticeDTO.setNoticeId((maxId));
                } else {
                    maxId++;
                    noticeDTO.setNoticeId((maxId));
                }
            }

        } catch (NullPointerException e){
            noticeDTO.setNoticeId(1);
        }

        noticeBO.saveNotice(noticeDTO);
        return "redirect:/notice";
    }

    //  Value name ("noticeId") must be equal
    @GetMapping(value = "/delete/{noticeId}")
    public String deleteNotice(@PathVariable int noticeId) {
        if(noticeBO.findNoticeById(noticeId) != null){
            noticeBO.deleteNotice(noticeId);
            return "redirect:/notice";
        }
        else{
            return  "Notice is not available";
        }
    }

/*
  //OR You can Use @RequestParam Annotation. If You Used It
  //Jsp href =  <a href="/delete/?noticeId=${a.noticeId}"> Delete </a>

    @RequestMapping("delete")
    public String deleteNotice(@RequestParam String noticeId) {
        try {
            noticeBO.deleteNotice ( noticeId );
        }catch (Exception e){
            System.out.println ("Notice Id =" +noticeId+" Not Found" );
        }
        return "redirect:/notice";
    }
    * */
}//End Class


























