package lk.sliit.hotelManagement.controller.humanResourceController.salary;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.hr.AccountsDTO;
import lk.sliit.hotelManagement.dto.hr.ActivityListDTO;
import lk.sliit.hotelManagement.dto.manager.EmployeeDTO;
import lk.sliit.hotelManagement.service.custom.HumanResourceBO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import lk.sliit.hotelManagement.service.custom.ManageBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class ActivityController {

    @Autowired
    HumanResourceBO humanResourceBO;
    @Autowired
    IndexLoginBO indexLoginBO;
    @Autowired
    ManageBO manageBO;

    @GetMapping("/activityList")
    public String activityList(Model model){
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        List<EmployeeDTO> p = manageBO.findAllUser();
        model.addAttribute("loadAllUsers", p);
        List<ActivityListDTO> p1 = humanResourceBO.findAllActivity();
        model.addAttribute("listAllActivity", p1);
        return "activityList";
    }


    @RequestMapping(value = "deleteActivity/{activityId}")// Delete Activity
    public void deleteEmployee(@PathVariable("activityId") int activityId, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

            try {
                humanResourceBO.deleteActivity(activityId);
            } catch (Exception e) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('You Cant Delete this Employee. This" +
                        " Employee Already Saved in Another Table');");
                out.println("location='/manageUser';");
                out.println("</script>");
            }
            response.sendRedirect("/activityList");

    }


    @PostMapping("/hrActivity")
    public String saveAccounts(@ModelAttribute ActivityListDTO activityListDTO1, Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        try {
            ActivityListDTO activityListDTO = humanResourceBO.findHighestActivityId();
            ActivityListDTO accountsDTO2 = null;
            try {
                accountsDTO2 = humanResourceBO.findActivityById(activityListDTO1.getActivityId());
            } catch (NullPointerException d) {
                int maxId = (activityListDTO.getActivityId());
                if (activityListDTO1.getActivityId() == (maxId)) {
                    activityListDTO1.setActivityId((maxId));
                } else {
                    maxId++;
                    activityListDTO1.setActivityId(maxId);
                }
            }
        } catch (NullPointerException e) {
            activityListDTO1.setActivityId(1);
        }
        humanResourceBO.saveActivity(activityListDTO1);
        return "redirect:/activityList";
    }

}
