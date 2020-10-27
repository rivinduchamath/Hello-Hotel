package lk.sliit.hotelManagement.controller.banquetController;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.banquet.BanquetAddDTO;
import lk.sliit.hotelManagement.service.custom.BanquetBO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.List;

@Controller
public class BanquetCheckAvailability {
    @Autowired
    IndexLoginBO indexLoginBO;
    @Autowired
    BanquetBO banquetBO;

    @GetMapping("/banquetCheckAvailability")
    public String loginPage(Model model){

        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        return "banquetCheckAvailability";
    }
    @PostMapping("/banquetCheckAvailability")
    public ModelAndView checkAvailability(@RequestParam Date date,Model model) {
        ModelAndView mv = new ModelAndView("banquetCheckAvailability");
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        String answer1;
        String answer2;
        String answer3;
        int count= banquetBO.checkAvailability(date);
        if(count==2)
            answer1=": Unavailable";
        else
            answer1=": Available";
        model.addAttribute("checkDate",date);
        model.addAttribute("answer1",answer1);

        int count1= banquetBO.checkHall1Availability(date);
        if(count1==1)
            answer2="Unavailable";
        else
            answer2="Available";
        model.addAttribute("answer2",answer2);

        int count2= banquetBO.checkHall2Availability(date);
        if(count2==1)
            answer3="Unavailable";
        else
            answer3="Available";
        model.addAttribute("answer3",answer3);

        List<BanquetAddDTO> list = banquetBO.findCheckDateBanquets(date);
        model.addAttribute("loadTable",list);

        return mv;
    }
}
