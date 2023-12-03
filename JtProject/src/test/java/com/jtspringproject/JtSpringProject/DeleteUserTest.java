import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.mockito.Mockito.*;

class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private Connection mockConnection;

    @Mock
    private PreparedStatement mockPreparedStatement;

    @Mock
    private ResultSet mockResultSet;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    void testDeleteUser() throws Exception {
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        mockMvc.perform(MockMvcRequestBuilders.post("/deleteuser")
                .param("userid", "1"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/index"))
                .andReturn();

        verify(mockConnection, times(1)).prepareStatement(anyString());
        verify(mockPreparedStatement, times(1)).setInt(eq(1), eq(1));
        verify(mockPreparedStatement, times(1)).executeUpdate();
    }

    @Test
    void testUpdateUserProfile() throws Exception {
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        mockMvc.perform(MockMvcRequestBuilders.post("/updateuser")
                .param("userid", "1")
                .param("username", "John")
                .param("email", "john@example.com")
                .param("password", "newpassword")
                .param("address", "123 Main St"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/index"))
                .andReturn();

        verify(mockConnection, times(1)).prepareStatement(anyString());
        verify(mockPreparedStatement, times(1)).setString(eq(1), eq("John"));
        verify(mockPreparedStatement, times(1)).setString(eq(2), eq("john@example.com"));
        verify(mockPreparedStatement, times(1)).setString(eq(3), eq("newpassword"));
        verify(mockPreparedStatement, times(1)).setString(eq(4), eq("123 Main St"));
        verify(mockPreparedStatement, times(1)).setInt(eq(5), eq(1));
        verify(mockPreparedStatement, times(1)).executeUpdate();
    }
}
