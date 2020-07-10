package lk.sliit.employeeManagement.service.custom;

import lk.sliit.employeeManagement.dto.ManageUserDTO;
import lk.sliit.employeeManagement.dto.NoticeDTO;
import lk.sliit.employeeManagement.service.SuperBO;

import java.util.List;

public interface ManageBO extends SuperBO {
    void save(ManageUserDTO manageUserDTO);

    List<ManageUserDTO> findAllUser();
}
