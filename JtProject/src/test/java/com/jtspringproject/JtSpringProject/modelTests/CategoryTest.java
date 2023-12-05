package modelTests;

import com.jtspringproject.JtSpringProject.models.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CategoryTest {

    @Test
    public void testInitializeCategory() {
        Category category = new Category();

        assertNotNull(category);
        assertEquals(0, category.getId());
        assertEquals(null, category.getName());
    }

    @Test
    public void testAssignAndRetrieveId() {
        Category category = new Category();
        category.setId(42);

        assertEquals(42, category.getId());
    }

    @Test
    public void testAssignAndRetrieveName() {
        Category category = new Category();
        category.setName("UpdatedTestCategory");

        assertEquals("UpdatedTestCategory", category.getName());
    }
}
