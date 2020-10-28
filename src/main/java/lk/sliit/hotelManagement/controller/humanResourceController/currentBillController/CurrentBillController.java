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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class CurrentBillController {

    @Autowired
    IndexLoginBO indexLoginBO;

    @Autowired
    HumanResourceBO humanResourceBO;

    @Autowired
    CurrentBO currentBO;

    @GetMapping ("/currentBill")//load Curernt bill page
    public ModelAndView loadCurrentBillDetails(Model model) {
        ModelAndView modelAndView = new ModelAndView("currentBill");
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        List<CurrentBillDTO> cbDTOList = currentBO.findAllCurrentBills();
        modelAndView.addObject("loadCBTable", cbDTOList);
        return modelAndView;
    }

    @PostMapping("saveCurrentBill")//save Current
    public String saveCurrentBillForm(@ModelAttribute CurrentBillDTO currentBillDTO){
        try {

            CurrentBillDTO current = currentBO.findHighestCurrentBillId();
            CurrentBillDTO currentBillDTO1 = null;
            try {
                currentBillDTO1 = currentBO.findById(currentBillDTO.getBillId());

            }catch (NullPointerException d){
                int maxId = (current.getBillId());
                if (currentBillDTO.getBillId()==(maxId)) {//Update Bill Id
                    currentBillDTO.setBillId((maxId));
                } else {//New Current bill
                    maxId++;
                    currentBillDTO.setBillId((maxId));
                }
            }

        } catch (NullPointerException e){
            currentBillDTO.setBillId(1);
        }
        currentBO.saveCurrentBill(currentBillDTO);//save
        return "redirect:/currentBill";
    }

    @RequestMapping(value = "deleteCurrentBill/{billId}")
    public void deleteEmployee(@PathVariable("billId") int billId, HttpServletResponse response) throws IOException {

            currentBO.deleteCurrentBill(billId);
            response.sendRedirect("/currentBill");


    }

}
