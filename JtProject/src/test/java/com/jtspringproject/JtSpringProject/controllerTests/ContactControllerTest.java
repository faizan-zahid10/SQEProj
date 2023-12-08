package com.jtspringproject.JtSpringProject.controllerTests;

import com.jtspringproject.JtSpringProject.controller.ContactController;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactControllerTest {

    @Test
    public void testShowContactPage() {
        ContactController contactController = new ContactController();
        String viewName = contactController.showContactPage();
        assertEquals("Contact", viewName);
    }
}
