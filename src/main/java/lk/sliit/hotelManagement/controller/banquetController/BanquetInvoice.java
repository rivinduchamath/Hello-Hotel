package lk.sliit.hotelManagement.controller.banquetController;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.banquet.BanquetAddDTO;
import lk.sliit.hotelManagement.service.custom.BanquetBO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class BanquetInvoice {
    @Autowired
    IndexLoginBO indexLoginBO;
    @Autowired
    BanquetBO banquetBO;

    @GetMapping("/banquetInvoice")
    public ModelAndView loginPage(@RequestParam int billId,Model model){
        ModelAndView mv = new ModelAndView("banquetInvoice");
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        BanquetAddDTO banquetInvoice = banquetBO.findBanquetBillById(billId);
        mv.addObject("data",banquetInvoice);

        return mv;
    }

}
