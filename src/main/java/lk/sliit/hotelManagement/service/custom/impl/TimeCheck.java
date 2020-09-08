package lk.sliit.hotelManagement.service.custom.impl;

import lk.sliit.hotelManagement.dao.TimeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeCheck implements lk.sliit.hotelManagement.service.custom.TimeCheck {

    @Autowired
    TimeDAO timeDAO;
}
