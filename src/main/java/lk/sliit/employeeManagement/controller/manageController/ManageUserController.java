package lk.sliit.employeeManagement.controller.manageController;

import lk.sliit.employeeManagement.controller.SuperController;
import lk.sliit.employeeManagement.dto.ManageUserDTO;
import lk.sliit.employeeManagement.service.custom.IndexLoginBO;
import lk.sliit.employeeManagement.service.custom.ManageBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.web.util.NestedServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ManageUserController {
    @Autowired
    IndexLoginBO indexLoginBO;
    @Autowired
    ManageBO manageBO;


    @GetMapping("/manageUser")
    public String loginPage(HttpServletResponse response, Model model, HttpServletRequest request)  {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        List<ManageUserDTO> p = manageBO.findAllUser();
        model.addAttribute("loadAllUserTable", p);
        return "manageUser";
    }



    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute ManageUserDTO manageUserDTO, Model model){
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        manageBO.save(manageUserDTO);
        return "redirect:/manageUser";
    }



}
