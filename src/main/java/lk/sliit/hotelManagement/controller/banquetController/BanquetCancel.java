package lk.sliit.hotelManagement.controller.banquetController;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.banquet.BanquetAddDTO;
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
public class BanquetCancel {
    @Autowired
    IndexLoginBO indexLoginBO;
    @Autowired
    BanquetBO banquetBO;

    @GetMapping("/banquetDelete")
    public ModelAndView loginPage(Model model){
        ModelAndView mv = new ModelAndView("banquetCancel");
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        List<BanquetAddDTO> list1 = banquetBO.findConfirmedBanquet();
        mv.addObject("loadTable1",list1);

        List<BanquetAddDTO> list2 = banquetBO.findUnconfirmedBanquet();
        mv.addObject("loadTable2",list2);

        return mv;
    }

    @RequestMapping("/updateBanquetStatusToCancel")
    public String updateBanquetStatusToCancel(@RequestParam int orderId) {
        banquetBO.updateBanquetStatusToCancel(orderId);
        return "redirect:/banquets";
    }

    @RequestMapping("deleteBanquet")
    public String deleteBanquet(@RequestParam int idNo) {
        banquetBO.deleteBanquet(idNo);
        return "redirect:/banquetDelete";
    }

}
