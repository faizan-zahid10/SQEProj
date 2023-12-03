package com.jtspringproject.JtSpringProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {

    @GetMapping("/Contact")
    public String showContactPage() {
        return "Contact"; // Assuming your JSP file is named "contact.jsp" and is located in the "src/main/resources/templates" directory.
    }
}

