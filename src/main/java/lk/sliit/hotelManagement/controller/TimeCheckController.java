package lk.sliit.hotelManagement.controller;


import lk.sliit.hotelManagement.dto.timeCheckDTO;
import lk.sliit.hotelManagement.service.custom.TimeCheckBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.sql.Time;


@Controller
public class TimeCheckController {

@Autowired
TimeCheckBO timeCheck1;

    @GetMapping("/le")
    public String profile(){
        return "time";
    }

    @PostMapping("/loadTime")
    public String dateTime(@ModelAttribute timeCheckDTO meCheck) {
        Time a = Time.valueOf(meCheck.getTimeSett()+":00");
        meCheck.setDate(a);
        timeCheck1.setTime(meCheck);
        System.out.println(meCheck.getTimeSett());
        return "time";
    }


}