package lk.sliit.hotelManagement.service.custom.impl;

import lk.sliit.hotelManagement.dao.TimeDAO;


import lk.sliit.hotelManagement.dto.timeCheckDTO;
import lk.sliit.hotelManagement.entity.TimeCheck;
import lk.sliit.hotelManagement.entity.reservation.Customer;
import lk.sliit.hotelManagement.service.custom.TimeCheckBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;

@Service
public class TimeCheckBOImpl implements TimeCheckBO {

    @Autowired
    TimeDAO timeDAO;


    @Override
    public void setTime(timeCheckDTO meCheck) {
        timeDAO.save(new TimeCheck(
                meCheck.getId(),
                Time.valueOf(meCheck.getTimeSett()+":00")
        ));

    }
}
