package com.jtspringproject.JtSpringProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @GetMapping("/Profile")
    public String showProfilePage() {
        return "profile"; // Assuming your JSP file is named "profile.jsp"
    }
}
