package lk.sliit.employeeManagement.controller.contactsController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactsController {
    @GetMapping("/contacts")
    public String loginPage(){
        return "contacts";
    }
}
