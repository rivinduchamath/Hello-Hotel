package lk.sliit.employeeManagement.service.custom.impl;

import lk.sliit.employeeManagement.dao.ManageDAO;
import lk.sliit.employeeManagement.dto.ManageUserDTO;
import lk.sliit.employeeManagement.dto.NoticeDTO;
import lk.sliit.employeeManagement.entity.Notice;
import lk.sliit.employeeManagement.entity.inventory.Inventory;
import lk.sliit.employeeManagement.entity.manager.ManageUser;
import lk.sliit.employeeManagement.service.custom.ManageBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class ManageBOImpl implements ManageBO {
    @Autowired
    ManageDAO manageDAO;

    @Override
    public void save(ManageUserDTO manageUserDTO) {
        manageDAO.save(new ManageUser(
                manageUserDTO.getUserId(),
                manageUserDTO.getName(),
                manageUserDTO.getPosition(),
                manageUserDTO.getAddress(),
                manageUserDTO.getPassword(),
                manageUserDTO.getSalary(),
                manageUserDTO.getEmail(),
                manageUserDTO.getMobileNo(),
                manageUserDTO.getGender(),
                manageUserDTO.getImage(),
                manageUserDTO.getDate()
        ));
    }

    @Override
    public List<ManageUserDTO> findAllUser() {
        Iterable<ManageUser> all = manageDAO.findAll();
        List<ManageUserDTO> dtos = new ArrayList<>();
        for (ManageUser manageUser: all) {
            dtos.add(new ManageUserDTO(
                    manageUser.getUserId(),
                    manageUser.getName(),
                    manageUser.getPosition(),
                    manageUser.getAddress(),
                    manageUser.getPassword(),
                    manageUser.getSalary(),
                    manageUser.getEmail(),
                    manageUser.getMobileNo(),
                    manageUser.getGender(),
                    manageUser.getImage(),
                    manageUser.getDate()
            ));
        }
        return dtos;
    }
}
