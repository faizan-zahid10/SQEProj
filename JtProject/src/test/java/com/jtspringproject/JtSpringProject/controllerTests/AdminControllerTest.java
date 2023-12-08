package com.jtspringproject.JtSpringProject.controllerTests;

import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;
import com.jtspringproject.JtSpringProject.controller.AdminController;
import static org.junit.jupiter.api.Assertions.assertEquals;
class AdminControllerTest {

    @Test
    public void testLogout() {
        AdminController adminController = new AdminController();
        String loginPage = adminController.returnIndex();
        assertEquals("adminlogin", loginPage);
    }

    @Test
    public void testAdminHome() {
        AdminController adminController = new AdminController();
        adminController.adminlogcheckin=1;
        String result = adminController.adminHome(new ConcurrentModel());
        assertEquals("adminHome", result);
    }

}
