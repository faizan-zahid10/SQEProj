package modelTests;

import com.jtspringproject.JtSpringProject.models.Category;
import com.jtspringproject.JtSpringProject.models.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProductTest {

    @Test
    public void testInitializeProduct() {
        Product product = new Product();

        assertNotNull(product);
        assertEquals(0, product.getId());
        assertEquals(null, product.getName());
        assertEquals(null, product.getImage());
        assertEquals(null, product.getCategory());
        assertEquals(0, product.getQuantity());
        assertEquals(0, product.getPrice());
        assertEquals(0, product.getWeight());
        assertEquals(null, product.getDescription());
    }

    @Test
    public void testAssignAndRetrieveId() {
        Product product = new Product();
        product.setId(7);

        assertEquals(7, product.getId());
    }

    @Test
    public void testAssignAndRetrieveName() {
        Product product = new Product();
        product.setName("UpdatedTestProduct");

        assertEquals("UpdatedTestProduct", product.getName());
    }

    @Test
    public void testAssignAndRetrieveImage() {
        Product product = new Product();
        product.setImage("updated-test-image.jpg");

        assertEquals("updated-test-image.jpg", product.getImage());
    }

    @Test
    public void testAssignAndRetrieveCategory() {
        Product product = new Product();
        Category category = new Category();
        category.setId(42);
        product.setCategory(category);

        assertEquals(category, product.getCategory());
    }

    @Test
    public void testAssignAndRetrieveQuantity() {
        Product product = new Product();
        product.setQuantity(10);

        assertEquals(10, product.getQuantity());
    }

    @Test
    public void testAssignAndRetrievePrice() {
        Product product = new Product();
        product.setPrice(150);

        assertEquals(150, product.getPrice());
    }

    @Test
    public void testAssignAndRetrieveWeight() {
        Product product = new Product();
        product.setWeight(300);

        assertEquals(300, product.getWeight());
    }

    @Test
    public void testAssignAndRetrieveDescription() {
        Product product = new Product();
        product.setDescription("Updated product description");

        assertEquals("Updated product description", product.getDescription());
    }
}
