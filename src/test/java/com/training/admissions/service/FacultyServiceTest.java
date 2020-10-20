package com.training.admissions.service;

import com.training.admissions.dto.FacultyDTO;
import com.training.admissions.entity.Faculty;
import com.training.admissions.repository.FacultyRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class FacultyServiceTest {

    @Mock
    private FacultyRepository facultyRepository = mock(FacultyRepository.class);
    @InjectMocks
    private FacultyService facultyService = new FacultyService(facultyRepository);

    @Test
    public void createFaculty() {
        FacultyDTO dto = new FacultyDTO();
        dto.setNameEn("f");
        dto.setNameUk("ф");
        dto.setDescriptionEn("d");
        dto.setDescriptionUk("d");
        dto.setBudgetCapacity(10);
        dto.setTotalCapacity(20);
        dto.setRequiredSubject1En("s");
        dto.setRequiredSubject1Uk("s");
        dto.setRequiredSubject2En("g");
        dto.setRequiredSubject2Uk("g");
        dto.setRequiredSubject3En("v");
        dto.setRequiredSubject3Uk("v");


        Faculty faculty = new Faculty();
        faculty.setNameEn("f");
        faculty.setNameUk("ф");
        faculty.setDescriptionEn("d");
        faculty.setDescriptionUk("d");
        faculty.setBudgetCapacity(10);
        faculty.setTotalCapacity(20);
        faculty.setRequiredSubject1En("s");
        faculty.setRequiredSubject1Uk("s");
        faculty.setRequiredSubject2En("g");
        faculty.setRequiredSubject2Uk("g");
        faculty.setRequiredSubject3En("v");
        faculty.setRequiredSubject3Uk("v");


        when(facultyRepository.save(any(Faculty.class))).thenReturn(faculty);

        Faculty faculty1 = facultyService.createFaculty(dto);

        verify(facultyRepository, times(1)).save(faculty);


    }
}