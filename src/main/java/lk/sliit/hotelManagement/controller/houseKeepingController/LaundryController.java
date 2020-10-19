package lk.sliit.hotelManagement.controller.houseKeepingController;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.houseKeeping.LaundryDTO;
import lk.sliit.hotelManagement.service.custom.HouseKeepingBO;
import lk.sliit.hotelManagement.service.custom.HumanResourceBO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Date;


@Controller
public class LaundryController {

    @Autowired
    IndexLoginBO indexLoginBO;
    @Autowired
    HouseKeepingBO houseKeepingBO;
    @Autowired
    HumanResourceBO humanResourceBO;

    //Load Dashboard Page
    @GetMapping("/laundryOrder")
    public String housekeeping(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "laundryOrder";
    }

    @PostMapping("/addLaundry")
    public String saveForLaundry(@ModelAttribute LaundryDTO laundryDTO, Model model) {

        try {
            LaundryDTO laundryDTO2 = houseKeepingBO.findHighestId();
            LaundryDTO laundryDTO1 = null;
            try {
                laundryDTO1 = houseKeepingBO.findLaundryOrderById(laundryDTO.getLaundryId());
            } catch (NullPointerException d) {
                int maxId = (laundryDTO2.getLaundryId());
                if (laundryDTO.getLaundryId() == (maxId)) {
                    laundryDTO.setLaundryId((maxId));
                } else {
                    maxId++;
                    laundryDTO.setLaundryId((maxId));
                }
            }
        } catch (NullPointerException e) {
            laundryDTO.setLaundryId(1);
        }
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        laundryDTO.setOrderHolder(SuperController.idNo);
        houseKeepingBO.saveLaundry(laundryDTO);
        return "redirect:/laundryOrder";
    }
}





