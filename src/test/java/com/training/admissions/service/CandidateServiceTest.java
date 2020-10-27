package com.training.admissions.service;

import com.training.admissions.entity.Candidate;
import com.training.admissions.entity.Faculty;
import com.training.admissions.repository.CandidateProfileRepository;
import com.training.admissions.repository.CandidateRepository;
import com.training.admissions.repository.FacultyRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@Sql(value = {"/create-user-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/create-user-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class CandidateServiceTest {
    @Autowired
    private CandidateRepository candidateRepository;
    private CandidateProfileRepository candidateProfileRepository;
    @Test
    public void getAllCandidates() {
        Assert.assertEquals(2,candidateRepository.findAll().size());
    }

    @Test
    public void getById() {
        Optional<Candidate> actualCandidate = candidateRepository.findById(1L);
        Assert.assertEquals("admin", actualCandidate.get().getUsername());
    }

    @Test
    public void getByUsername() {
        Optional<Candidate> actualCandidate = candidateRepository.findByUsername("user");
        Assert.assertEquals("user", actualCandidate.get().getUsername());
    }

//    @Test
//    public void createCandidate() {
//
//    }

//    @Test
//    public void updateCandidate() {
//    }
//
//    @Test
//    public void setCandidateRequestsStatus() {
//    }

    @Test
    public void deleteById() {
       candidateRepository.deleteById(1L);
        Assert.assertEquals(1, candidateRepository.findAll().size());
    }

//    @Test
//    public void updateCandidateProfile() {
//    }
}