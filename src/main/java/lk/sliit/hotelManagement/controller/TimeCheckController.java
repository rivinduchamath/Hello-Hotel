package lk.sliit.hotelManagement.controller;


import lk.sliit.hotelManagement.dto.timeCheck;
import lk.sliit.hotelManagement.service.custom.TimeCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TimeCheckController {

@Autowired
TimeCheck timeCheck1;

    @GetMapping("/le")
    public String profile(){
        return "time";
    }
    @PostMapping("/loadTime")
    public String profil2e(@ModelAttribute timeCheck meCheck){
        System.out.println(meCheck.getTimeSett());
        return "time";
    }
}
