package lk.sliit.hotelManagement.controller.manageController;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.hr.DepartmentDTO;
import lk.sliit.hotelManagement.dto.inventory.InventoryNoticeDTO;
import lk.sliit.hotelManagement.dto.manager.EmployeeDTO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import lk.sliit.hotelManagement.service.custom.KitchenBO;
import lk.sliit.hotelManagement.service.custom.ManageBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ManageController {
    @Autowired
    IndexLoginBO indexLoginBO;
    @Autowired
    KitchenBO kitchenBO;
    @Autowired
    ManageBO manageBO;
    @GetMapping("/manage")
    public String loginPage(Model model){
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "manage";
    }
    @GetMapping("/kitchenDailyActivityReport")
    public String KitchenReport(Model model){
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        List<InventoryNoticeDTO> p = kitchenBO.findWeekOrderNotice();
        model.addAttribute("loadFoodOrderWeek", p);
        return "kitchenDailyActivityReport";
    }
    @GetMapping("loadDepartment")
    public ModelAndView loadDepartment(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo((SuperController.idNo)));

        ModelAndView mav = new ModelAndView("loadDepartment");

        List<DepartmentDTO> p2 = manageBO.findAllDepartment();
        model.addAttribute("loadDepartment", p2);

        return mav;
    }
    @PostMapping("/saveDepartment")
    public String saveUser(@ModelAttribute DepartmentDTO departmentDTO, Model model) {

        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        try {
            DepartmentDTO departmentDTO1 = manageBO.findHighestDepartmentId();
            DepartmentDTO departmentDTO2 = null;
            try {
                departmentDTO2 = manageBO.findDepertmentById(departmentDTO.getDepartmentId());
            } catch (NullPointerException d) {
                int maxId = (departmentDTO1.getDepartmentId());
                if (departmentDTO.getDepartmentId() == (maxId)) {
                    departmentDTO.setDepartmentId((maxId));
                } else {
                    maxId++;
                    departmentDTO.setDepartmentId((maxId));
                }
            }

        } catch (NullPointerException e) {
            departmentDTO.setDepartmentId(1);
        }
        manageBO.saveDepertment(departmentDTO);
        return "redirect:/loadDepartment";
    }


}
