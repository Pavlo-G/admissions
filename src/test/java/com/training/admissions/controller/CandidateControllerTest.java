package com.training.admissions.controller;

import com.training.admissions.entity.Candidate;
import com.training.admissions.exception.CandidateNotFoundException;
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

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@Sql(value = {"/create-user-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = { "/create-user-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)

public class CandidateControllerTest {
    @Autowired
    private MockMvc mockMvc;


    @Test
    @WithMockUser(authorities = "ADMIN")
    public void getCandidateById() throws Exception {
        this.mockMvc.perform(get("/admin/candidate/edit/2"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("candidate",
                        Matchers.hasProperty("id", Matchers.equalTo(2L))))
                .andExpect(model().attribute("candidate",
                        Matchers.hasProperty("username", Matchers.equalToIgnoringCase("user"))))
                .andExpect(model().attribute("candidate",
                        Matchers.hasProperty("candidateProfile", Matchers.hasProperty("email",
                                Matchers.equalToIgnoringCase("user@user.com")))));
    }

    @Test
    @WithMockUser(authorities = "ADMIN")
    public void getCandidateByIdNotExists() throws Exception {
        this.mockMvc.perform(get("/admin/candidate/edit/245"))
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof CandidateNotFoundException));
    }

    @Test
    @WithMockUser(authorities = "ADMIN")
    public void getAllCandidates() throws Exception {
        this.mockMvc.perform(get("/admin/candidate"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("page",
                        Matchers.hasItems(
                                Matchers.<Candidate>hasProperty("username", Matchers.equalToIgnoringCase("admin")),
                                Matchers.<Candidate>hasProperty("username", Matchers.equalToIgnoringCase("user")))));


    }

}