package com.jtspringproject.JtSpringProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

    @GetMapping("/userLogin")
    public String showLoginPage() {
        return "userLogin"; // Assuming your JSP file is named "contact.jsp" and is located in the "src/main/resources/templates" directory.
    }
}


