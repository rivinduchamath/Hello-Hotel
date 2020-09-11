package lk.sliit.hotelManagement.controller.banquetController;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.banquet.BanquetAddDTO;
import lk.sliit.hotelManagement.dto.reservation.CustomerDTO;
import lk.sliit.hotelManagement.service.custom.BanquetBO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BanquetController {
    @Autowired
    IndexLoginBO indexLoginBO;
    @Autowired
    BanquetBO banquetBO;

    @GetMapping("/banquets")
    public ModelAndView loginPage(Model model) {
        ModelAndView mv = new ModelAndView("banquet");
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        List<BanquetAddDTO> list = banquetBO.findNextBanquets();
        mv.addObject("loadTable2",list);

        List<BanquetAddDTO> list2 = banquetBO.findTodayBanquets();
        mv.addObject("loadTable1",list2);

        return mv;
    }

    @RequestMapping("/updateBanquetStatus")
    public String updateBanquetStatus(@RequestParam int orderId) {
        banquetBO.updateBanquetStatus(orderId);
        return "redirect:/banquets";
    }


}
