package lk.sliit.employeeManagement.service.custom;

import lk.sliit.employeeManagement.dto.HouseKeepingDTO;
import lk.sliit.employeeManagement.service.SuperBO;

import java.util.List;

public interface HouseKeepingBO extends SuperBO {
    List<HouseKeepingDTO> findAllRooms();

    HouseKeepingDTO findTopByOrderByIdDesc();
}
