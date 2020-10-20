package com.training.admissions.service;

import com.training.admissions.dto.CandidateDTO;
import com.training.admissions.dto.CandidateProfileDTO;
import com.training.admissions.entity.Candidate;
import com.training.admissions.entity.CandidateStatus;
import com.training.admissions.entity.Role;
import com.training.admissions.repository.CandidateProfileRepository;
import com.training.admissions.repository.CandidateRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.refEq;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CandidateServiceTest {


    @Autowired
    private CandidateService candidateService;
    @MockBean
    private CandidateRepository candidateRepository;
    @MockBean
    private CandidateProfileRepository candidateProfileRepository;
    @MockBean
    private PasswordEncoder passwordEncoder;

    @Test
    public void findById() {
        Candidate candidate =
                Candidate.builder()
                        .id(1L)
                        .username("candidate")
                        .password("password")
                        .role(Role.USER)
                        .candidateStatus(CandidateStatus.ACTIVE)
                        .build();

        Mockito.when(candidateRepository.findByUsername("candidate")).thenReturn(java.util.Optional.ofNullable(candidate));
        Candidate candidateDb = candidateService.getByUsername("candidate");
        Assert.assertNotNull(candidateDb);
        Mockito.verify(candidateRepository,Mockito.times(1)).findByUsername("candidate");
    }

    @Test
    public void getAllCandidates() {
    }
}