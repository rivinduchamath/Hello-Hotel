package lk.sliit.employeeManagement.service.custom.impl;

import lk.sliit.employeeManagement.dao.EmployeeDAO;
import lk.sliit.employeeManagement.dto.EmployeeDTO;
import lk.sliit.employeeManagement.entity.Employee;
import lk.sliit.employeeManagement.service.custom.EmployeeBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeBOImpl implements EmployeeBO {

    @Autowired
    EmployeeDAO employeeDAO;

    @Override
    public EmployeeDTO findByIdNoAndPassword(String idNo, String password) {
        Employee employee = employeeDAO.findByIdNoAndPassword(idNo, password);
        return new EmployeeDTO (
                employee.getIdNo (),
                employee.getPassword ());
    }

    @Override
    public EmployeeDTO getEmployeeByIdNo(String idNo) {
        Employee employee = employeeDAO.findOne (idNo);
        return new EmployeeDTO (employee.getIdNo (),
                employee.getName (),
                employee.getMobileNumber (),
                employee.getEmail (),
                employee.getAddress (),
                employee.getOccupation (),
                employee.getPassword (),
                employee.getDateOfBirth (),
                employee.getGender (),
                employee.getDate (),
                employee.getPic (),
                employee.isAdmin ()
        );

    }
}
