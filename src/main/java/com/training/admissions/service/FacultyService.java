package com.training.admissions.service;

import com.training.admissions.dto.FacultyDTO;
import com.training.admissions.exception.FacultyAlreadyExistsException;
import com.training.admissions.exception.FacultyNotFoundException;
import com.training.admissions.model.Faculty;
import com.training.admissions.repository.FacultyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
public class FacultyService {


    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }


    public List<Faculty> getAllFaculties() {
        log.info("Get All Faculties");
        List<Faculty> list =facultyRepository.findAll();
        return list;

    }

    public Faculty getById(Long id) {
        log.info("Get faculty by id: " + id);
        return facultyRepository.findById(id).orElseThrow(FacultyNotFoundException::new);
    }

    @Transactional
    public Faculty createFaculty(FacultyDTO facultyDTO) {
        if (facultyRepository.findByName(facultyDTO.getName()).isEmpty()) {
            Faculty createdFaculty = facultyRepository.save(Faculty.builder()
                    .name(facultyDTO.getName())
                    .description(facultyDTO.getDescription())
                    .budgetCapacity(facultyDTO.getBudgetCapacity())
                    .totalCapacity(facultyDTO.getTotalCapacity())
                    .build());
            log.info("Faculty created: " + createdFaculty.getName());
            return createdFaculty;
        }
        throw new FacultyAlreadyExistsException("Faculty already exists");
    }


    public void deleteById(Long id) {
        facultyRepository.deleteById(id);
        log.info("Faculty removed id: " + id);
    }
}
