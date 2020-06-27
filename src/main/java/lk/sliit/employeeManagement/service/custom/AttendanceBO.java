package lk.sliit.employeeManagement.service.custom;

import lk.sliit.employeeManagement.dto.AttendanceDTO;
import lk.sliit.employeeManagement.service.SuperBO;

import java.util.List;

public interface AttendanceBO extends SuperBO {
    List<AttendanceDTO> findTodayAttendance();
}
