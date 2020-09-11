package lk.sliit.hotelManagement.controller.humanResourceController.currentBillController;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.hr.CurrentBillDTO;
import lk.sliit.hotelManagement.dto.kitchen.MenuDTO;
import lk.sliit.hotelManagement.service.custom.CurrentBO;
import lk.sliit.hotelManagement.service.custom.HumanResourceBO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CurrentBillController {

    @Autowired
    IndexLoginBO indexLoginBO;

    @Autowired
    HumanResourceBO humanResourceBO;

    @Autowired
    CurrentBO currentBO;

    @GetMapping ("/currentBill")
    public ModelAndView loadCurrentBillDetails(Model model) {
        ModelAndView modelAndView = new ModelAndView("currentBill");
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        List<CurrentBillDTO> cbDTOList = currentBO.findAllCurrentBills();
        modelAndView.addObject("loadCBTable", cbDTOList);
        return modelAndView;
    }

    @PostMapping("saveCurrentBill")
    public String saveCurrentBillForm(@ModelAttribute CurrentBillDTO currentBillDTO){
        try {
            System.out.println("ccccccccccccccccccccccccccccccccc"+currentBillDTO);
            CurrentBillDTO current = currentBO.findHighestCurrentBillId();
            System.out.println("sss3333333333333333"+current);
            CurrentBillDTO currentBillDTO1 = null;
            try {
                currentBillDTO1 = currentBO.findById(currentBillDTO.getBillId());
                System.out.println("ssssssssssssssssssssssssssssssssssssssssssssssss");
            }catch (NullPointerException d){
                int maxId = (current.getBillId());
                if (currentBillDTO.getBillId()==(maxId)) {
                    currentBillDTO.setBillId((maxId));
                } else {
                    maxId++;
                    currentBillDTO.setBillId((maxId));
                }
            }

        } catch (NullPointerException e){
            currentBillDTO.setBillId(1);
        }
        currentBO.saveCurrentBill(currentBillDTO);
        return "redirect:/currentBill";
    }

}
