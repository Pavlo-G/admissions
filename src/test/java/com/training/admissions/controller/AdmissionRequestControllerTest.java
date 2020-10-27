package com.training.admissions.controller;

import com.training.admissions.entity.AdmissionRequest;
import com.training.admissions.entity.AdmissionRequestStatus;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.hamcrest.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@Sql(value = {"/create-user-before.sql", "/create-faculty-before.sql", "/create-admission-request-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/create-user-after.sql", "/create-faculty-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class AdmissionRequestControllerTest {
    @Autowired
    private MockMvc mockMvc;


    @Test
    public void getRequestForm() throws Exception {
        this.mockMvc.perform(get("/candidate/submit_request_form")
                .param("id", "1")
                .param("admissionOpen", "true")
                .with(user("user")))
                .andExpect(status().isOk())
                .andExpect(model().attribute("candidate",
                        Matchers.hasProperty("username", Matchers.equalTo("user"))))
                .andExpect(model().attribute("faculty",
                        Matchers.hasProperty("nameEn", Matchers.equalToIgnoringCase("Faculty of Art"))));

    }

    @Test
    public void createRequestFromCandidate() throws Exception {
        this.mockMvc.perform(post("/candidate/submit_request")
                .param("candidateId","2")
                .param("facultyId","2")
                .param("requiredSubject1Grade","6")
                .param("requiredSubject2Grade","7")
                .param("requiredSubject3Grade","8")
                .with(user("user")))
                .andExpect(redirectedUrl("/candidate/candidate_requests"));


    }

    @Test
    public void getAllUserRequests() throws Exception {
        this.mockMvc.perform(get("/candidate/candidate_requests")
                .with(user("user")))
                .andExpect(status().isOk())
                .andExpect(model().attribute("page",
                        Matchers.hasItems(
                                Matchers.<AdmissionRequest>hasProperty(
                                        "id", Matchers.equalTo(1L)
                                ))))
                .andExpect(model().attribute("page",
                        Matchers.hasItems(
                                Matchers.<AdmissionRequest>hasProperty(
                                        "admissionRequestStatus", Matchers.equalTo(AdmissionRequestStatus.NEW)
                                ))))
                .andExpect(model().attribute("page",
                        Matchers.hasItems(
                                Matchers.<AdmissionRequest>hasProperty(
                                        "candidate", Matchers.hasProperty("id", Matchers.equalTo(2L))
                                ))))
                .andExpect(model().attribute("page",
                        Matchers.hasItems(
                                Matchers.<AdmissionRequest>hasProperty(
                                        "faculty", Matchers.hasProperty("id", Matchers.equalTo(1L))
                                ))));


    }

    @Test
    public void deleteRequest() throws Exception {
        this.mockMvc.perform(post("/candidate/delete_request/1")
                .with(user("user")))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/candidate/candidate_requests"));
    }

    @Test
    public void getRequestsForFacultyById() {
    }

    @Test
    public void getRequestById() {
    }

    @Test
    public void requestApprove() {
    }
}