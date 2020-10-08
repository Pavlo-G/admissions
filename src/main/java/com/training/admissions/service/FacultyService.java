package com.training.admissions.service;

import com.training.admissions.dto.FacultyDTO;
import com.training.admissions.entity.Faculty;
import com.training.admissions.exception.FacultyNotFoundException;
import com.training.admissions.repository.FacultyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }


    public Page<Faculty> getAllFaculties(Pageable pageable) {
        return facultyRepository.findAll(pageable);
    }

    public Faculty getById(Long id) {
        return facultyRepository.findById(id)
                .orElseThrow(() -> new FacultyNotFoundException("Faculty not found! by id: " + id));
    }


    public void deleteById(Long id) {
        facultyRepository.deleteById(id);
        log.info("Faculty removed id: " + id);
    }


    public Faculty createFaculty(FacultyDTO facultyDTO) {
        return facultyRepository.save(Faculty.builder()
                .name(facultyDTO.getName())
                .description(facultyDTO.getDescription())
                .budgetCapacity(facultyDTO.getBudgetCapacity())
                .totalCapacity(facultyDTO.getTotalCapacity())
                .requiredSubject1(facultyDTO.getRequiredSubject1())
                .requiredSubject2(facultyDTO.getRequiredSubject2())
                .requiredSubject3(facultyDTO.getRequiredSubject3())
                .admissionOpen(true)
                .build());
    }


    public int updateFaculty(FacultyDTO facultyDTO) {
        return facultyRepository.updateFaculty(
                facultyDTO.getId(),
                facultyDTO.getName(),
                facultyDTO.getDescription(),
                facultyDTO.getBudgetCapacity(),
                facultyDTO.getTotalCapacity(),
                facultyDTO.getRequiredSubject1(),
                facultyDTO.getRequiredSubject2(),
                facultyDTO.getRequiredSubject3(),
                facultyDTO.isAdmissionOpen());
    }


}
