package lk.sliit.hotelManagement.controller.banquetController;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.banquet.BanquetAddDTO;
import lk.sliit.hotelManagement.service.custom.BanquetBO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BanquetBill {
    @Autowired
    IndexLoginBO indexLoginBO;
    @Autowired
    BanquetBO banquetBO;

    @GetMapping("/banquetBill")
    public ModelAndView loginPage(Model model){
        ModelAndView mv = new ModelAndView("banquetBill");
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        List<BanquetAddDTO> list = banquetBO.findBanquetBill();
        mv.addObject("loadTable",list);

        return mv;
    }

    @PostMapping("updateBill")
    public String updateBill(@ModelAttribute BanquetAddDTO banquetAddDTO){
        banquetBO.updateBill(banquetAddDTO);
        return "redirect:/banquetBill";
    }
}
