package com.jtspringproject.JtSpringProject.controllerTests;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletResponse;
import com.jtspringproject.JtSpringProject.controller.UserController;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserControllerTest {

    @Test
    public void testUserLogout() {
        UserController userController = new UserController();
        MockHttpServletResponse response = new MockHttpServletResponse();
        String redirectPage = userController.logout(response);
        System.out.println(redirectPage);
        assertEquals("/userLogin", redirectPage);
    }
}
