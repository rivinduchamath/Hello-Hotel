package lk.sliit.hotelManagement.controller;


import lk.sliit.hotelManagement.dto.timeCheckDTO;

import lk.sliit.hotelManagement.service.custom.TimeCheckBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.time.LocalDateTime;
import java.sql.Date;

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
        System.out.println("s222223333ssssssssssssssssssssssssssssss222222222222222222sss");
        System.out.println(meCheck.getTimeSett()+"sssssssssssssssssssssssssssssssssssssssssssssssssssssss");
        Time a = Time.valueOf(meCheck.getTimeSett()+":00");
        System.out.println(meCheck.getTimeSett()+"sss22222222222222ssssssssssssssssssssssssss");

        meCheck.setDate(a);
        timeCheck1.setTime(meCheck);
        System.out.println(meCheck.getTimeSett());
        return "time";
    }


}