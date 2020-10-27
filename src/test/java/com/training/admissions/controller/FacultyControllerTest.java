package com.training.admissions.controller;

import com.training.admissions.entity.Faculty;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@Sql(value = {"/create-faculty-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/create-faculty-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class FacultyControllerTest {
    @Autowired
    private MockMvc mockMvc;


    @Test
    @WithMockUser(authorities = "ADMIN")
    public void getAllFaculties() throws Exception {
        this.mockMvc.perform(get("/admin/workspace"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("page",
                        Matchers.hasItems(
                                Matchers.<Faculty>hasProperty("nameEn", Matchers.equalToIgnoringCase("Faculty of Art")),
                                Matchers.<Faculty>hasProperty("nameEn", Matchers.equalToIgnoringCase("Faculty of Economics")))));

    }

    @Test
    @WithMockUser(authorities = "ADMIN")
    public void createNewFaculty() throws Exception {
        this.mockMvc.perform(post("/admin/faculty/add").
                param("nameEn", "Faculty of Computer Science")
                .param("nameUk", "Факультет Компьютерних наук")
                .param("descriptionEn", "Faculty of Computer Science")
                .param("descriptionUk", "Faculty of Computer Science")
                .param("budgetCapacity", "10")
                .param("totalCapacity", "20")
                .param("requiredSubject1En", "Math")
                .param("requiredSubject1Uk", "Математика")
                .param("requiredSubject2En", "Physics")
                .param("requiredSubject2Uk", "Фізика")
                .param("requiredSubject3En", "Ukrainian")
                .param("requiredSubject3Uk", "Українська")
                .param("admissionOpen", "true"))
                .andExpect(redirectedUrl("/admin/workspace"));

        this.mockMvc.perform(get("/admin/workspace"))
                .andExpect(model().attribute("page",
                        Matchers.hasItems(
                                Matchers.<Faculty>hasProperty("nameEn", Matchers.equalToIgnoringCase("Faculty of Art")),
                                Matchers.<Faculty>hasProperty("nameEn", Matchers.equalToIgnoringCase("Faculty of Economics")),
                                Matchers.<Faculty>hasProperty("nameEn", Matchers.equalToIgnoringCase("Faculty of Computer Science")))));


    }
}