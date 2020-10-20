package lk.sliit.hotelManagement.controller.banquetController;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.banquet.BanquetAddDTO;
import lk.sliit.hotelManagement.service.custom.BanquetBO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BanquetReport {
    @Autowired
    IndexLoginBO indexLoginBO;
    @Autowired
    BanquetBO banquetBO;

    @GetMapping("/banquetReport")
    public ModelAndView loginPage(Model model) {
        ModelAndView mv = new ModelAndView("banquetReport");
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        List<BanquetAddDTO> list = banquetBO.findLastWeakBanquets();
        mv.addObject("loadTable",list);

        double reportTotal =0;
        for(BanquetAddDTO i:list){
            reportTotal += i.getTotal();
        }
        model.addAttribute("fullTotal",reportTotal);

        double tax = reportTotal * 0.04;
        model.addAttribute("tax",tax);

        double profit =reportTotal-tax;
        model.addAttribute("profit",profit);

        return mv;
    }
}
