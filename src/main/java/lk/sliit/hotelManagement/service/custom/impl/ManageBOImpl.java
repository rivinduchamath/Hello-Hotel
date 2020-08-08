package lk.sliit.hotelManagement.service.custom.impl;

import lk.sliit.hotelManagement.dao.manageSystem.EmployeeDAO;
import lk.sliit.hotelManagement.dao.hrDAO.DepartmentDAO;
import lk.sliit.hotelManagement.dto.hr.DepartmentDTO;
import lk.sliit.hotelManagement.dto.inventory.ItemTypeDTO;
import lk.sliit.hotelManagement.dto.manager.EmployeeDTO;
import lk.sliit.hotelManagement.entity.hr.Department;
import lk.sliit.hotelManagement.entity.manager.Employee;
import lk.sliit.hotelManagement.service.custom.ManageBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class ManageBOImpl implements ManageBO {
    @Autowired
    EmployeeDAO manageDAO;

    @Autowired
    DepartmentDAO humanResourceDAO;

    @Override
    public void save(EmployeeDTO employeeDTO) {

        System.out.println("Sssssssssssssssssssssssssssssssssssssssssssssssssss"+employeeDTO.getDepartment());
        manageDAO.save(new Employee(
                employeeDTO.getUserId(),
                employeeDTO.getName(),
                employeeDTO.getMobileNo(),
                employeeDTO.getEmail(),
                employeeDTO.getAddress(),
                employeeDTO.getPosition(),
                employeeDTO.getPassword(),
                employeeDTO.getDateOfBirth(),
                employeeDTO.getGender(),
                employeeDTO.getSalary(),
                employeeDTO.getDate(),
                employeeDTO.getImage(),
                humanResourceDAO.findOne(employeeDTO.getDepartment())
        ));
    }

    @Override
    public List<EmployeeDTO> findAllUser() {
        Iterable<Employee> all = manageDAO.findAll();
        List<EmployeeDTO> dtos = new ArrayList<>();
        for (Employee employee: all) {
            dtos.add(new EmployeeDTO(
                    employee.getUserId(),
                    employee.getName(),
                    employee.getMobileNo(),
                    employee.getEmail(),
                    employee.getAddress(),
                    employee.getPosition(),
                    employee.getPassword(),
                    employee.getDateOfBirth(),
                    employee.getGender(),
                    employee.getSalary(),
                    employee.getDate(),
                    employee.getImage(),
                    employee.getDepartment().getDepartmentId()
            ));
        }
        return dtos;
    }

    @Override
    public void deleteEmployee(String userId) {
        manageDAO.delete(userId);
    }

    @Override
    public List<DepartmentDTO> findAllDepartment() {
        Iterable<Department> all = humanResourceDAO.findAll();
        List<DepartmentDTO> dtos = new ArrayList<>();
        for (Department department: all) {
            dtos.add(new DepartmentDTO(
                   department.getDepartmentId(),
                    department.getDepartmentName()
            ));
        }
        return dtos;
    }
}
