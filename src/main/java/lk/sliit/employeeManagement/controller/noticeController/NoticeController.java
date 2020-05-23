package lk.sliit.employeeManagement.controller.noticeController;

import lk.sliit.employeeManagement.dto.NoticeDTO;
import lk.sliit.employeeManagement.service.custom.NoticeBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class NoticeController { //notice.jsp For All Notice

    @Autowired
    NoticeBO noticeBO;

    @GetMapping("notice")
    public ModelAndView load(Model model){
        ModelAndView mav = new ModelAndView("notice");
        NoticeDTO dd = noticeBO.findId();
        try {
            int x = Integer.parseInt(dd.getNoticeId()) +1;
            model.addAttribute("noticeID",x);
        }catch (NullPointerException e){
            model.addAttribute("noticeID",1);
        }


        List<NoticeDTO> p  = noticeBO.findAll();
        mav.addObject("loadTable",p);

        return mav;
    }

    @RequestMapping("noticSave")
    public String saveForm(@ModelAttribute NoticeDTO noticeDTO){
           noticeBO.saveNotice(noticeDTO);
           return "redirect:/notice";
    }


    @RequestMapping("delete")
    public String delete(@RequestParam String notId){
            noticeBO.deleteNotice(notId);
        return "redirect:/notice";
    }
}//End Class
