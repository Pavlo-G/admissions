package com.training.admissions.service;

import com.training.admissions.dto.FacultyDTO;
import com.training.admissions.entity.Faculty;
import com.training.admissions.exception.FacultyNotFoundException;
import com.training.admissions.repository.FacultyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    public void blockUnblockRegistration(FacultyDTO facultyDTO) {

        facultyRepository.blockUnblockRegistration(facultyDTO.getId(), facultyDTO.isAdmissionOpen());
    }


    public Faculty createFaculty(FacultyDTO facultyDTO) {
        return facultyRepository.save(
                Faculty.builder()
                        .id(facultyDTO.getId())
                        .nameEn(facultyDTO.getNameEn())
                        .nameUk(facultyDTO.getNameUk())
                        .descriptionEn(facultyDTO.getDescriptionEn())
                        .descriptionUk(facultyDTO.getDescriptionUk())
                        .budgetCapacity(facultyDTO.getBudgetCapacity())
                        .totalCapacity(facultyDTO.getTotalCapacity())
                        .requiredSubject1En(facultyDTO.getRequiredSubject1En())
                        .requiredSubject1Uk(facultyDTO.getRequiredSubject1Uk())
                        .requiredSubject2En(facultyDTO.getRequiredSubject2En())
                        .requiredSubject2Uk(facultyDTO.getRequiredSubject2Uk())
                        .requiredSubject3En(facultyDTO.getRequiredSubject3En())
                        .requiredSubject3Uk(facultyDTO.getRequiredSubject3Uk())
                        .admissionOpen(facultyDTO.getId() == null || facultyDTO.isAdmissionOpen())
                        .build());
    }


}
