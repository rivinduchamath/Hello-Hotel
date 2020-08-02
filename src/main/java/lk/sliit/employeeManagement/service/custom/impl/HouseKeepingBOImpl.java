package lk.sliit.employeeManagement.service.custom.impl;

import lk.sliit.employeeManagement.dao.houseKeepingDAO.HouseKeepingDAO;
import lk.sliit.employeeManagement.service.custom.HouseKeepingBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HouseKeepingBOImpl implements HouseKeepingBO {

    @Autowired
    HouseKeepingDAO houseKeepingDAO;


}
