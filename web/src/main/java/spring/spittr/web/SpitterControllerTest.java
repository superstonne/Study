package spring.spittr.web;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import spring.spittr.Spitter;
import spring.spittr.data.SpitterRepository;

import javax.xml.validation.Validator;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class SpitterControllerTest {

    @Test
    public void shouldShowRegistration() throws Exception {
        SpitterController controller = new SpitterController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/spitter/register"))
                .andExpect(view().name("registerForm"));
    }

    @Autowired
    private Validator validator;
    private LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }
    @Test
    public void shouldProcessRegistration() throws Exception {
        SpitterRepository repository = mock(SpitterRepository.class);
        Spitter unsaved = new Spitter("ni", "24hours", "Nick", "");
        Spitter saved = new Spitter(24L, "ni", "24hours", "Nick", "");
        when(repository.save(unsaved)).thenReturn(saved);
        SpitterController controller = new SpitterController(repository);
        MockMvc mockMvc = standaloneSetup(controller).setValidator(validator()).build();
        mockMvc.perform(post("/spitter/register")
                .param("firstName", "Nick")
                .param("lastName", "")
                .param("username", "ni")
                .param("password", "24hours"))
                .andExpect(redirectedUrl("/spitter/ni"));
        verify(repository, atLeastOnce()).save(unsaved);
    }
}
