package lk.sliit.hotelManagement.controller.humanResourceController.salary;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.hr.*;
import lk.sliit.hotelManagement.dto.manager.EmployeeDTO;
import lk.sliit.hotelManagement.service.custom.HumanResourceBO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import lk.sliit.hotelManagement.service.custom.ManageBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@Controller
public class SalaryController {
    // automate the object creation and connect with the relevant interfaces
    @Autowired
    IndexLoginBO indexLoginBO;
    @Autowired
    ManageBO manageBO;
    @Autowired
    HumanResourceBO humanResourceBO;

    @GetMapping("/salary")//Load Page
    public ModelAndView salary(Model model) {
        ModelAndView mav = new ModelAndView("salary");
        List<MonthlySalary> p = humanResourceBO.findAllUserList();
        List<SalaryDTO> p2 = humanResourceBO.findAllsalaryStateNotFalse();
        List<EmployeeDTO> p3 = humanResourceBO.findAllsalaryStateNotFalseTot();
        model.addAttribute("loadAllUsers", p);
        model.addAttribute("listEmployeesTableSalary", p3);
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        //Pass Salary Row Count
        //Get All Data In Salary Table
        List<SalaryDTO> salaryDTOS = humanResourceBO.findAllSalary();
        int i = 0;
        for (EmployeeDTO e : p3) {
            i++; // Get Count
        }
        mav.addObject("salaryCount", i);
        return mav;
    }

    //Load All Salaries To a Table
    @GetMapping("/allSalary")
    public ModelAndView loadAllSalary(Model model, @ModelAttribute EmployeeDTO employee, HttpServletRequest request, HttpServletResponse response) throws ServletException, IllegalStateException, IOException {
        ModelAndView mav = new ModelAndView("allSalary");
        mav.addObject("listEmployeesTableSalarya", humanResourceBO.findAllSalary());
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return mav;
    }

    @PostMapping("salarySave") // save salary details
    public String loadInvoicePage(@ModelAttribute SalaryDTO salaryDTO, Model model, HttpServletRequest request) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        try {
            SalaryDTO employeeDTO1 = humanResourceBO.findHighestSalaryId();
            SalaryDTO employeeDTO2 = null;
            try {
                employeeDTO2 = humanResourceBO.findSalarybyId(salaryDTO.getSalaryId());
            } catch (NullPointerException d) {
                int maxId = (employeeDTO1.getSalaryId());
                if (salaryDTO.getSalaryId() == (maxId)) {
                    salaryDTO.setSalaryId((maxId));
                } else {
                    maxId++;
                    salaryDTO.setSalaryId((maxId));
                }
            }

        } catch (NullPointerException e) {
            salaryDTO.setSalaryId(1);
        }
        humanResourceBO.saveSalary(salaryDTO);
        return "redirect:/salary";
    }

    @GetMapping("salaryPayment") // load payment invoice page
    public String loadInvoicePage(@ModelAttribute SalaryPayDTO salaryDTO, Model model) throws IOException {
        ModelAndView mav = new ModelAndView("salaryPayment");
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        try {
            List<SalaryPayDTO> salaryDTOS = humanResourceBO.getSalaryPayment(salaryDTO.getSource());
            model.addAttribute("getSalaryData", salaryDTOS);

        } catch (Exception e) { }
       return "salaryPayment";
    }

    @GetMapping("/salarySettings") // load salary settings page
    public String salarySettings(Model model){
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        List<SalarySettingsDTO> salaryDTOS = humanResourceBO.getSalarySet();
        model.addAttribute("getSalarySettings", salaryDTOS);

        return "salarySettings";
    }

    @PostMapping("/saveSettings") // save settings
    public String saveAccounts(@ModelAttribute SalarySettingsDTO settingsDTO, Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        try {
            SalarySettingsDTO settingsDTO1 = humanResourceBO.findHighestSettingSalary();
            SalarySettingsDTO settingsDTO2 = null;
            try {
                settingsDTO2 = humanResourceBO.findsalarySettingById(settingsDTO.getId());
            } catch (NullPointerException d) {
                int maxId = (settingsDTO1.getId());
                if (settingsDTO.getId() == (maxId)) {
                    settingsDTO.setId((maxId));
                } else {
                       maxId++;
                    settingsDTO.setId(maxId);
                }
            }
        } catch (NullPointerException e) {
            settingsDTO.setId(1);
        }

        humanResourceBO.saveSettingSalary(settingsDTO);
        return "redirect:/salarySettings";
    }


    @PostMapping("deleteSalaryTable")//When Payment Is Complete Delete Salary Data Which Clicked
    public String deleteSalary(@ModelAttribute SalaryDTO salaryDTO, Model model) {
        //Pass All Data as a String And Add Only Salary Id To a String array
        String[] sourceAry = salaryDTO.getSource ( ).split ( " " );

        //Delete Salary From Salary Table
        for (String s : sourceAry) {

            humanResourceBO.deleteSalary ( s );
        }
        return "redirect:/salary";
    }//End Delete Method
}

