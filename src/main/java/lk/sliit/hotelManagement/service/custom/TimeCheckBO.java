package lk.sliit.hotelManagement.service.custom;


import lk.sliit.hotelManagement.dto.timeCheckDTO;

import java.util.Date;
import java.util.List;

public interface TimeCheckBO  {

    void setTime(timeCheckDTO meCheck);


    List<timeCheckDTO> getReqTime(Date date, Date tdate, Date tdate2);
}
