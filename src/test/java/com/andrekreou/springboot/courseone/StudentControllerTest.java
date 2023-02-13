package com.andrekreou.springboot.courseone;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Should return the student with the corresponding value")
    public void getStudent() throws Exception {
        mockMvc.perform(get("/students/student"))
                .andExpect(status().isOk())
                .andExpect(header().string("custom-header", "andreas"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"id\":1,\"firstName\":\"Andreas\",\"lastName\":\"Kreouzos\"}"));
    }

    @Test
    @DisplayName("Should return the list of students with the corresponding values")
    public void getStudents() throws Exception {
        mockMvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[{\"id\":1,\"firstName\":\"Andreas\",\"lastName\":\"Kreouzos\"}," +
                        "{\"id\":2,\"firstName\":\"Anastasios\",\"lastName\":\"Plataras\"}," +
                        "{\"id\":3,\"firstName\":\"Antonios\",\"lastName\":\"Lazos\"}," +
                        "{\"id\":4,\"firstName\":\"Georgios Ioannis\",\"lastName\":\"Zacharopoulos\"}]"));
    }
}
