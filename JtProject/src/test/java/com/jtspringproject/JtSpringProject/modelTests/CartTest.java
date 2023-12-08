package com.jtspringproject.JtSpringProject.modelTests;

import com.jtspringproject.JtSpringProject.models.Cart;
import com.jtspringproject.JtSpringProject.models.Product;
import com.jtspringproject.JtSpringProject.models.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CartTest {

    @Test
    public void testInitializationCart() {
        Cart cart = new Cart();

        assertNotNull(cart);
        assertNotNull(cart.getProducts());
        assertEquals(0, cart.getProducts().size());
    }

    @Test
    public void testAddProductToShoppingCart() {
        Cart cart = new Cart();
        Product product = new Product();

        cart.addProduct(product);

        assertEquals(1, cart.getProducts().size());
        assertEquals(product, cart.getProducts().get(0));
    }

    @Test
    public void testCustomerSetAndGet() {
        Cart cart = new Cart();
        User user = new User();
        user.setUsername("");

        cart.setCustomer(user);

        assertEquals(user, cart.getCustomer());
    }

    @Test
    public void testRemoveProductFromBasket() {
        Cart cart = new Cart();
        Product product = new Product();

        cart.addProduct(product);
        cart.removeProduct(product);

        assertEquals(0, cart.getProducts().size());
    }
}
