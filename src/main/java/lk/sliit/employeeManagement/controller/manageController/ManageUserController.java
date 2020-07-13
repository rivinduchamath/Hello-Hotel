package lk.sliit.employeeManagement.controller.manageController;

import lk.sliit.employeeManagement.controller.SuperController;
import lk.sliit.employeeManagement.dto.manager.EmployeeDTO;
import lk.sliit.employeeManagement.service.custom.IndexLoginBO;
import lk.sliit.employeeManagement.service.custom.ManageBO;
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


    @GetMapping("/manageUser")
    public String loginPage(HttpServletResponse response, Model model, HttpServletRequest request) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        List<EmployeeDTO> p = manageBO.findAllUser();
        model.addAttribute("loadAllUserTable", p);
        return "manageUser";
    }


    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute EmployeeDTO employeeDTO, Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        manageBO.save(employeeDTO);
        return "redirect:/manageUser";
    }

    @RequestMapping(value = "deleteEmployee/{userId}")
    public void deleteEmployee(@PathVariable("userId") String userId, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (SuperController.idNo.equals(userId)) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('You Cant Delete this Employee. This" +
                    " Employee Already Saved in Another Table');");
            out.println("location='/manageUser';");
            out.println("</script>");

        } else {
            manageBO.deleteEmployee(userId);
            response.sendRedirect("/manageUser");
        }

    }


}
