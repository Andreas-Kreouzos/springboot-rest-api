package com.andrekreou.springboot.courseone;

import com.andrekreou.springboot.courseone.bean.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;

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

    @Test
    @DisplayName("Should return the student with the corresponding path variable values")
    public void studentPathVariable() throws Exception {
        mockMvc.perform(get("/students/1/Andreas/Kreouzos"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"id\":1,\"firstName\":\"Andreas\",\"lastName\":\"Kreouzos\"}"));
    }

    @Test
    @DisplayName("Should return the student which created through a post request")
    public void createStudent() throws Exception {
        mockMvc.perform(post("/students/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":6,\"firstName\":\"Andreas\",\"lastName\":\"Kreouzos\"}"))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"id\":6,\"firstName\":\"Andreas\",\"lastName\":\"Kreouzos\"}"));
    }

    @Test
    @DisplayName("Should return the student which updated through a put request")
    public void updateStudent() throws Exception {
        mockMvc.perform(put("/students/1/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":6,\"firstName\":\"Andreas\",\"lastName\":\"Kreouzos\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(6)))
                .andExpect(jsonPath("$.firstName", is("Andreas")))
                .andExpect(jsonPath("$.lastName", is("Kreouzos")));
    }

    @Test
    @DisplayName("Should delete the student through a delete request")
    public void deleteStudentTest() throws Exception {
        mockMvc.perform(post("/students/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"firstName\":\"Andreas\",\"lastName\":\"Kreouzos\"}"))
                .andExpect(status().isCreated());

        mockMvc.perform(delete("/students/1/delete"))
                .andExpect(status().isOk())
                .andExpect(content().string("Student deleted successfully!"));
    }
}
