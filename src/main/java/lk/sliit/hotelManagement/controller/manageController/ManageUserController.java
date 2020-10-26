package lk.sliit.hotelManagement.controller.manageController;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.hr.DepartmentDTO;
import lk.sliit.hotelManagement.dto.inventory.ItemTypeDTO;
import lk.sliit.hotelManagement.dto.kitchen.MenuDTO;
import lk.sliit.hotelManagement.dto.manager.EmployeeDTO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import lk.sliit.hotelManagement.service.custom.MailSend;
import lk.sliit.hotelManagement.service.custom.ManageBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ManageUserController {
    @Autowired
    IndexLoginBO indexLoginBO;
    @Autowired
    ManageBO manageBO;
    @Autowired
    MailSend mailSend;

    @GetMapping("/manageUser")//Load Manage User Page
    public String loginPage(HttpServletResponse response, Model model, HttpServletRequest request) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        EmployeeDTO employeeDTO = new EmployeeDTO();
        model.addAttribute("employeeDTO", employeeDTO);
        List<EmployeeDTO> p = manageBO.findAllUser(); //find All registered Employees
        model.addAttribute("loadAllUserTable", p);
        List<DepartmentDTO> p2 = manageBO.findAllDepartment();//Find All Department in comboBox
        model.addAttribute("loadDepartment", p2);
        return "manageUser";
    }


    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute EmployeeDTO employeeDTO, Model model) {

        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        try {
            EmployeeDTO employeeDTO1 = manageBO.findHighestEmployeeId();
            EmployeeDTO employeeDTO2 = null;
            try {
                employeeDTO2 = manageBO.findEmployeeById(employeeDTO.getUserId());
            } catch (NullPointerException d) {
                int maxId = (employeeDTO1.getUserId());
                if (employeeDTO.getUserId() == (maxId)) {
                    employeeDTO.setUserId((maxId));
                } else {
                    maxId++;
                    employeeDTO.setUserId((maxId));
                }
            }

        } catch (NullPointerException e) {
            employeeDTO.setUserId(1);
        }
        manageBO.save(employeeDTO);
        try {
            mailSend.sendMailToNewEmployee(employeeDTO);//Send Mail
        } catch (Exception e) {

        }
        return "redirect:/manageUser";
    }

    @RequestMapping(value = "deleteEmployee/{userId}")// Delete Employee
    public void deleteEmployee(@PathVariable("userId") int userId, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (SuperController.idNo == (userId)) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('You Cant Delete this Employee. This" +
                    " Employee Already Saved in Another Table');");
            out.println("location='/manageUser';");
            out.println("</script>");

        } else {
            try {
                manageBO.deleteEmployee(userId);
            }catch (Exception e){
                out.println("<script type=\"text/javascript\">");
                out.println("alert('You Cant Delete this Employee. This" +
                        " Employee Already Saved in Another Table');");
                out.println("location='/manageUser';");
                out.println("</script>");
            }
            response.sendRedirect("/manageUser");
        }

    }


    @RequestMapping(value = "/sendemail")
    public String sendEmail() {
        return "Email sent successfully";
    }


}




