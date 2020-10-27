package com.training.admissions.service;

import com.training.admissions.entity.Faculty;
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

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@Sql(value = {"/create-faculty-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/create-faculty-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class FacultyServiceTest {
    @Autowired
    private  FacultyRepository facultyRepository;



    @Test
    public void getAllFaculties() {
        Assert.assertEquals(2, facultyRepository.findAll().size());
    }

    @Test

    public void getById() {
        Optional<Faculty> actualFaculty = facultyRepository.findById(1L);
        Assert.assertEquals("Faculty of Art", actualFaculty.get().getNameEn());
    }

    @Test
    public void deleteById() {
      facultyRepository.deleteById(1L);
        Assert.assertEquals(1, facultyRepository.findAll().size());
    }

    @Test
    public void blockUnblockRegistration() {
        facultyRepository.blockUnblockRegistration(1L,false);
        Assert.assertFalse(facultyRepository.findById(1L).get().isAdmissionOpen());
    }

    @Test
    public void createFaculty() {



    }
}