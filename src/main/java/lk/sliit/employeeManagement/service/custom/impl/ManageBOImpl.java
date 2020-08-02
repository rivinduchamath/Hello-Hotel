package lk.sliit.employeeManagement.service.custom.impl;

import lk.sliit.employeeManagement.dao.EmployeeDAO;
import lk.sliit.employeeManagement.dao.HumanResourceDAO;
import lk.sliit.employeeManagement.dto.manager.EmployeeDTO;
import lk.sliit.employeeManagement.entity.hr.Department;
import lk.sliit.employeeManagement.entity.manager.Employee;
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
    EmployeeDAO manageDAO;
    @Autowired
    HumanResourceDAO humanResourceDAO;

    @Override
    public void save(EmployeeDTO employeeDTO) {

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
}
