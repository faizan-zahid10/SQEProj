package com.jtspringproject.JtSpringProject.modelTests;

import com.jtspringproject.JtSpringProject.models.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserTest {

    @Test
    public void testAssignAndRetrieveId() {
        User user = new User();
        user.setId(8);

        assertEquals(8, user.getId());
    }

    @Test
    public void testInitializeUser() {
        User user = new User();

        assertNotNull(user);
        assertEquals(0, user.getId());
        assertEquals(null, user.getUsername());
        assertEquals(null, user.getEmail());
        assertEquals(null, user.getPassword());
        assertEquals(null, user.getRole());
        assertEquals(null, user.getAddress());
    }

    @Test
    public void testAssignAndRetrieveRole() {
        User user = new User();
        user.setRole("user");

        assertEquals("user", user.getRole());
    }

    @Test
    public void testAssignAndRetrievePassword() {
        User user = new User();
        user.setPassword("updatedpassword");

        assertEquals("updatedpassword", user.getPassword());
    }

    @Test
    public void testAssignAndRetrieveEmail() {
        User user = new User();
        user.setEmail("updated@test.com");

        assertEquals("updated@test.com", user.getEmail());
    }

    @Test
    public void testAssignAndRetrieveAddress() {
        User user = new User();
        user.setAddress("Oak St");

        assertEquals("Oak St", user.getAddress());
    }

    @Test
    public void testAssignAndRetrieveUsername() {
        User user = new User();
        user.setUsername("updateduser");

        assertEquals("updateduser", user.getUsername());
    }
}
