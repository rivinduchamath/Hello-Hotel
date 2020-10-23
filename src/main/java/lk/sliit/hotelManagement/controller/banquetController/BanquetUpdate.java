package lk.sliit.hotelManagement.controller.banquetController;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.banquet.BanquetAddDTO;
import lk.sliit.hotelManagement.dto.banquet.BanquetOrderDTO;
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
import java.util.List;

@Controller
public class BanquetUpdate {
    @Autowired
    IndexLoginBO indexLoginBO;
    @Autowired
    BanquetBO banquetBO;

    @GetMapping("/banquetUpdate")
    public ModelAndView loginPage( Model model){
        ModelAndView mv = new ModelAndView("banquetUpdate");
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        List<BanquetAddDTO> list = banquetBO.findUnconfirmedBanquet();
        mv.addObject("loadTable",list);

        return mv;

    }

    @RequestMapping("updateBanquet")
    public ModelAndView updateBanquet(@ModelAttribute BanquetAddDTO banquetAddDTO, HttpServletRequest request, Model model){
        try {
            int count = banquetBO.checkAvailability(banquetAddDTO.getDate());
            if(count <= 2) {
                if (banquetAddDTO.getHallId().equals("No 1")){
                    int banquetId = banquetBO.checkHall1AvailabilityAndGetBanquetId(banquetAddDTO.getDate());
                    int count1=banquetBO.checkHall1Availability(banquetAddDTO.getDate());
                    if (banquetAddDTO.getOrderId() == banquetId){
                        banquetBO.updateBanquetDetails(banquetAddDTO);
                        request.setAttribute("successfulMsg","updated successfully");

                    } else if(count1 < 1) {
                        banquetBO.updateBanquetDetails(banquetAddDTO);
                        request.setAttribute("successfulMsg","updated successfully");
                    }
                    else{
                        request.setAttribute("myp2","can not enter");
                    }
                }
                if (banquetAddDTO.getHallId().equals("No 2")){
                    int banquetId=banquetBO.checkHall2AvailabilityAndGetBanquetId(banquetAddDTO.getDate());
                    int count2=banquetBO.checkHall2Availability(banquetAddDTO.getDate());
                    if (banquetId == banquetAddDTO.getOrderId()){
                        banquetBO.updateBanquetDetails(banquetAddDTO);
                        request.setAttribute("successfulMsg","updated successfully");
                    } else if(count2 < 1) {
                        banquetBO.updateBanquetDetails(banquetAddDTO);
                        request.setAttribute("successfulMsg","updated successfully");
                    }
                    else{
                        request.setAttribute("myp2","can not enter");
                    }
                }
            }
            else{
                request.setAttribute("myp1","can not enter");
            }


        }catch (Exception e){

        }

        ModelAndView mv = new ModelAndView("banquetUpdate");
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        List<BanquetAddDTO> list = banquetBO.findUnconfirmedBanquet();
        mv.addObject("loadTable",list);

        return mv;

    }

}
