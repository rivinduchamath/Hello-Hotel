package lk.sliit.hotelManagement.controller.banquetController;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.banquet.BanquetAddDTO;
import lk.sliit.hotelManagement.dto.banquet.BanquetBillDTO;
import lk.sliit.hotelManagement.dto.banquet.BanquetOrderDTO;
import lk.sliit.hotelManagement.dto.reservation.CustomerDTO;
import lk.sliit.hotelManagement.service.custom.BanquetBO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BanquetAdd {
    @Autowired
    IndexLoginBO indexLoginBO;
    @Autowired
    BanquetBO banquetBO;

    @GetMapping("/banquetAdd")
    public ModelAndView loginPage(Model model) {
        ModelAndView mv = new ModelAndView("banquetAdd");
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        try {
            BanquetOrderDTO banquetOrderDTO = banquetBO.findTopBanquetId();
            int topBanquet = Integer.parseInt(banquetOrderDTO.getOrderId()) + 1;
            model.addAttribute("topBanquetId", topBanquet);
        } catch (NullPointerException e) {
            model.addAttribute("topBanquetId", 1);
        }

        try {
            CustomerDTO customerDTO = banquetBO.findTopCustomerId();
            int topCustomer = Integer.parseInt(customerDTO.getCustomerId()) + 1;
            model.addAttribute("topCustomerId", topCustomer);
        } catch (NullPointerException e){
        model.addAttribute("topCustomerId", 1);
        }

        try {
            BanquetBillDTO banquetBillDTO = banquetBO.findTopBanquetBillId();
            int topBill = Integer.parseInt(banquetBillDTO.getBillId()) + 1;
            model.addAttribute("topBanquetBillId", topBill);
        } catch (NullPointerException e){
            model.addAttribute("topBanquetBillId", 1);
        }

        List<CustomerDTO> list = banquetBO.findAllCustomers();
        mv.addObject("loadTable",list);

        return mv;
    }

    @RequestMapping("saveBanquet")
    public String saveForm(@ModelAttribute BanquetAddDTO banquetAddDTO){
        System.out.println("ssssssssssssssssssssssssssssssssssssssssssssssssssssssssss"+banquetAddDTO.getCustomerId());
        banquetBO.saveBanquet(banquetAddDTO);
        return "redirect:/banquetAdd";
    }
}
