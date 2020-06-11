package lk.sliit.employeeManagement.controller.noticeController;



import lk.sliit.employeeManagement.dto.NoticeDTO;
import lk.sliit.employeeManagement.service.custom.NoticeBO;
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

    @GetMapping("notice")
    public ModelAndView load(Model model) {
        ModelAndView mav = new ModelAndView("notice");
        NoticeDTO dd = noticeBO.findId();
        try {
            int x = Integer.parseInt(dd.getNoticeId()) + 1;
            model.addAttribute("noticeID", x);
        } catch (NullPointerException e) {
            model.addAttribute("noticeID", 1);
        }
        List<NoticeDTO> p = noticeBO.findAll();
        mav.addObject("loadTable", p);

        return mav;
    }

    @PostMapping("noticSave")
    public String saveForm(@ModelAttribute NoticeDTO noticeDTO) {
        noticeBO.saveNotice(noticeDTO);
        return "redirect:/notice";
    }

    @RequestMapping(value = "/delete/{noticeId}",method = RequestMethod.GET)
    public String deleteNotice(@PathVariable String noticeId) {
        if(noticeBO.findNoticeById(noticeId) != null){
            noticeBO.deleteNotice(noticeId);
            return "redirect:/notice";
        }
        else{
            return  "Notice is not available ";
        }
    }

/*
  OR You can Use @RequestParam Annotation  If You Used It
  Jsp href =  <a href="/delete/?noticeId=${a.noticeId}"> Delete </a>

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
