package lk.sliit.hotelManagement.controller;

import lk.sliit.hotelManagement.dto.timeCheckDTO;
import lk.sliit.hotelManagement.service.custom.TimeCheckBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.sql.Time;
import java.sql.Date;
import java.util.List;


@Controller
public class TimeCheckController {

@Autowired
TimeCheckBO timeCheck1;

    @GetMapping("/le")
    public String profile(Model model){
        return "time";
    }

    @PostMapping("/loadTime")
    public String dateTime(@ModelAttribute timeCheckDTO meCheck) {
        System.out.println("ssssssssssssssssssssssaaaaaaaaaaaaaaaaaaaaaaaaaaa"+meCheck);
        Time a = Time.valueOf(meCheck.getTimeSett()+":00");
        Time a1 = Time.valueOf(meCheck.getTimeSett2()+":00");
        meCheck.setTdate(a);
        meCheck.setTdate2(a1);
        Date date =Date.valueOf(meCheck.getDateSett());
        meCheck.setDate(date);
        timeCheck1.setTime(meCheck);
        System.out.println(meCheck.getTimeSett());
        return "redirect:/le";
    }


    @GetMapping("/loadTable")
    public String loadTable(Model model,@ModelAttribute timeCheckDTO meCheck){
        Time a = Time.valueOf(meCheck.getTimeSett()+":00");
        Time a1 = Time.valueOf(meCheck.getTimeSett2()+":00");
        meCheck.setTdate(a);
        meCheck.setTdate2(a1);
        Date date =Date.valueOf(meCheck.getDateSett());
        meCheck.setDate(date);
        List<timeCheckDTO> p1 =timeCheck1.getReqTime(meCheck.getDate(),meCheck.getTdate(),meCheck.getTdate2());
        model.addAttribute("loadTimeTable", p1);
        return "redirect:/le";
    }
}