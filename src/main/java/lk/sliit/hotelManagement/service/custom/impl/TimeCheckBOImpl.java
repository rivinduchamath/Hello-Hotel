package lk.sliit.hotelManagement.service.custom.impl;

import lk.sliit.hotelManagement.dao.TimeDAO;


import lk.sliit.hotelManagement.dto.beverage.BarOrderDTO;
import lk.sliit.hotelManagement.dto.timeCheckDTO;
import lk.sliit.hotelManagement.entity.TimeCheck;
import lk.sliit.hotelManagement.entity.barManage.BarOrders;
import lk.sliit.hotelManagement.entity.reservation.Customer;
import lk.sliit.hotelManagement.service.custom.TimeCheckBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Service
public class TimeCheckBOImpl implements TimeCheckBO {

    @Autowired
    TimeDAO timeDAO;


    @Override
    public void setTime(timeCheckDTO meCheck) {
        timeDAO.save(new TimeCheck(
                meCheck.getId(),
                Time.valueOf(meCheck.getTimeSett()+":00"),
                Time.valueOf(meCheck.getTimeSett2()+":00"),
                Date.valueOf(meCheck.getDateSett())
        ));

    }

    @Override
    public List<timeCheckDTO> getReqTime(java.util.Date date, java.util.Date tdate, java.util.Date tdate2) {


        Iterable<TimeCheck> all = timeDAO.findAllByTimeTwoGreaterThanEqualAndTimeOneLessThanEqualAndDateEquals(tdate2,tdate,date);
        Iterable<TimeCheck> all2 = timeDAO.findAllByTimeTwoLessThanEqualAndTimeOneGreaterThanEqualAndDateEquals(tdate2,tdate,date);

        System.out.println(date);
        System.out.println("Tset 1 "+tdate);
        System.out.println("Tset 2 "+tdate2);

        for (TimeCheck a : all) {
            System.out.println("AAAAAAAAAA "+a.getId());
            System.out.println("AAAAAAAAAA "+a.getTimeSett());
            System.out.println("AAAAAAAAAA "+a.getTimeSett2());
        }

        for (TimeCheck a : all2) {
            System.out.println("BBBBBBBBB "+a.getId());
            System.out.println("BBBBBBBBB "+a.getTimeSett());
            System.out.println("BBBBBBBBB "+a.getTimeSett2());
        }
        List<timeCheckDTO> dtos = new ArrayList<>();
        for (TimeCheck a : all) {
            dtos.add(new timeCheckDTO(
                    a.getId(),
                    a.getTimeSett(),
                    a.getTimeSett2(),
                    a.getDate()
            ));
        }
        return null;
    }
}
