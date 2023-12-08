package com.jtspringproject.JtSpringProject.controllerTests;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.jtspringproject.JtSpringProject.controller.AboutController;

public class AboutControllerTest {

    @Test
    public void testShowAboutPage() {
        AboutController aboutController = new AboutController();
        String viewName = aboutController.showAboutPage();
        assertEquals("about", viewName);
    }
}

