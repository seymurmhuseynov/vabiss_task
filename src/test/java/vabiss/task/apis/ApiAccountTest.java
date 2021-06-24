package vabiss.task.apis;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import vabiss.task.dao.DaoAccount;
import vabiss.task.model.RequestLoginOrRegistry;
import vabiss.task.model.Response;

@ContextConfiguration(classes = {ApiAccount.class})
@ExtendWith(SpringExtension.class)
public class ApiAccountTest {
    @Autowired
    private ApiAccount apiAccount;

    @MockBean
    private DaoAccount daoAccount;

    @Test
    public void testLogin() throws Exception {
        when(this.daoAccount.login((RequestLoginOrRegistry) any())).thenReturn(new Response());

        RequestLoginOrRegistry requestLoginOrRegistry = new RequestLoginOrRegistry();
        requestLoginOrRegistry.setPassword("admin@gmail.com");
        requestLoginOrRegistry.setUsername("admin");
        String content = (new ObjectMapper()).writeValueAsString(requestLoginOrRegistry);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/account/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.apiAccount)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"code\":200,\"message\":\"success: Done!\",\"response\":null}"));
    }

    @Test
    public void testRegistry() throws Exception {
        when(this.daoAccount.register((RequestLoginOrRegistry) any())).thenReturn(new Response());

        RequestLoginOrRegistry requestLoginOrRegistry = new RequestLoginOrRegistry();
        requestLoginOrRegistry.setPassword("admin@gmail.com");
        requestLoginOrRegistry.setUsername("admin");
        String content = (new ObjectMapper()).writeValueAsString(requestLoginOrRegistry);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/account/registry")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.apiAccount)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"code\":200,\"message\":\"success: Done!\",\"response\":null}"));
    }
}

