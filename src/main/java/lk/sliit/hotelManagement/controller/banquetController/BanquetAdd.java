package lk.sliit.hotelManagement.controller.banquetController;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.banquet.BanquetAddDTO;
import lk.sliit.hotelManagement.dto.banquet.BanquetBillDTO;
import lk.sliit.hotelManagement.dto.banquet.BanquetOrderDTO;
import lk.sliit.hotelManagement.dto.manager.EmployeeDTO;
import lk.sliit.hotelManagement.dto.reservation.CustomerDTO;
import lk.sliit.hotelManagement.service.custom.BanquetBO;
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
import java.util.Calendar;
import java.util.Date;
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
            int topBanquet = (banquetOrderDTO.getOrderId()) + 1;
            model.addAttribute("topBanquetId", topBanquet);
        } catch (NullPointerException e) {
            model.addAttribute("topBanquetId", 1);
        }

        try {
            CustomerDTO customerDTO = banquetBO.findTopCustomerId();
            int topCustomer = (customerDTO.getCustomerId()) + 1;
            model.addAttribute("topCustomerId", topCustomer);
        } catch (NullPointerException e){
            model.addAttribute("topCustomerId", 1);
        }

        try {
            BanquetBillDTO banquetBillDTO = banquetBO.findTopBanquetBillId();
            int topBill = (banquetBillDTO.getBillId()) + 1;
            model.addAttribute("topBanquetBillId", topBill);
        } catch (NullPointerException e){
            model.addAttribute("topBanquetBillId", 1);
        }

        List<CustomerDTO> list = banquetBO.findAllCustomers();
        mv.addObject("loadTable",list);

        return mv;
    }

    @RequestMapping("saveBanquet")
    public ModelAndView saveForm(@ModelAttribute BanquetAddDTO banquetAddDTO , HttpServletRequest request,Model model){

        try {
            int count = banquetBO.checkAvailability(banquetAddDTO.getDate());
            if(count<2) {
                if (banquetAddDTO.getHallId().equals("No 1")){
                    int count1=banquetBO.checkHall1Availability(banquetAddDTO.getDate());
                    if(count1<1) {
                        EmployeeDTO employeeDTO=(indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
                        banquetAddDTO.setSubmittedBy(employeeDTO.getName());
                        banquetBO.saveBanquet(banquetAddDTO);
                        request.setAttribute("successfulMsg","added successfully");
                    }
                    else{
                        request.setAttribute("myp2","can not enter");
                    }
                }
                if (banquetAddDTO.getHallId().equals("No 2")){
                    int count2=banquetBO.checkHall2Availability(banquetAddDTO.getDate());
                    if(count2 <1) {
                        EmployeeDTO employeeDTO=(indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
                        banquetAddDTO.setSubmittedBy(employeeDTO.getName());
                        banquetBO.saveBanquet(banquetAddDTO);
                        request.setAttribute("successfulMsg","added successfully");
                    }
                    else{
                        request.setAttribute("myp3","can not enter");
                    }
                }
            }
            else{
                request.setAttribute("myp1","can not enter");
            }


        }catch (Exception e){

        }
        ModelAndView mv = new ModelAndView("banquetAdd");
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        try {
            BanquetOrderDTO banquetOrderDTO = banquetBO.findTopBanquetId();
            int topBanquet = (banquetOrderDTO.getOrderId()) + 1;
            model.addAttribute("topBanquetId", topBanquet);
        } catch (NullPointerException e) {
            model.addAttribute("topBanquetId", 1);
        }

        try {
            CustomerDTO customerDTO = banquetBO.findTopCustomerId();
            int topCustomer = (customerDTO.getCustomerId()) + 1;
            model.addAttribute("topCustomerId", topCustomer);
        } catch (NullPointerException e){
            model.addAttribute("topCustomerId", 1);
        }

        try {
            BanquetBillDTO banquetBillDTO = banquetBO.findTopBanquetBillId();
            int topBill = (banquetBillDTO.getBillId()) + 1;
            model.addAttribute("topBanquetBillId", topBill);
        } catch (NullPointerException e){
            model.addAttribute("topBanquetBillId", 1);
        }

        List<CustomerDTO> list = banquetBO.findAllCustomers();
        mv.addObject("loadTable",list);
        return mv;

    }

}

