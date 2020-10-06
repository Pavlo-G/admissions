package com.training.admissions.service;

import com.training.admissions.dto.CandidateProfileDTO;
import com.training.admissions.dto.FacultyDTO;
import com.training.admissions.entity.CandidateProfile;
import com.training.admissions.exception.CandidateAlreadyExistsException;
import com.training.admissions.exception.CandidateNotFoundException;
import com.training.admissions.exception.FacultyAlreadyExistsException;
import com.training.admissions.exception.FacultyNotFoundException;
import com.training.admissions.entity.Faculty;
import com.training.admissions.repository.AdmissionRequestRepository;
import com.training.admissions.repository.FacultyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class FacultyService {

    private final AdmissionRequestRepository admissionRequestRepository;
    private final FacultyRepository facultyRepository;


    public FacultyService(FacultyRepository facultyRepository, AdmissionRequestRepository admissionRequestRepository) {
        this.admissionRequestRepository = admissionRequestRepository;
        this.facultyRepository = facultyRepository;
    }


    public List<Faculty> getAllFaculties() {
        log.info("Get All Faculties");

        return facultyRepository.findAll();

    }

    public Faculty getById(Long id) {
        log.info("Get faculty by id: " + id);
        return facultyRepository.findById(id)
                .orElseThrow(() -> new FacultyNotFoundException("Faculty not found! by id: " + id));
    }

    @Transactional
    public Faculty createFaculty(FacultyDTO facultyDTO) {
        facultyRepository.findByName(facultyDTO.getName()).
                ifPresent(s -> {
                    throw new FacultyAlreadyExistsException("Faculty with username - " + facultyDTO.getName() + " - already Exists");
                });

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


    public void deleteById(Long id) {
        facultyRepository.deleteById(id);
        log.info("Faculty removed id: " + id);
    }



    public Faculty updateFaculty(FacultyDTO facultyDTO) {

        Faculty faculty = Faculty.builder()
                .id(facultyDTO.getId())
                .name(facultyDTO.getName())
                .description(facultyDTO.getDescription())
                .budgetCapacity(facultyDTO.getBudgetCapacity())
                .totalCapacity(facultyDTO.getTotalCapacity())
                .admissionRequestList(facultyDTO.getAdmissionRequestsList())
                .requiredSubject1(facultyDTO.getRequiredSubject1())
                .requiredSubject2(facultyDTO.getRequiredSubject2())
                .requiredSubject3(facultyDTO.getRequiredSubject3())
                .admissionOpen(facultyDTO.isAdmissionOpen())
                .build();
        return facultyRepository.save(faculty);
    }

    @Transactional
    public Faculty blockAdmissionRequestRegistration(Long id) {
        Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(() -> new FacultyNotFoundException("Faculty with id: " + id + "not found!"));
        faculty.setAdmissionOpen(false);
        return facultyRepository.save(faculty);

    }
    @Transactional
    public Faculty unblockAdmissionRequestRegistration(Long id) {
        Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(() -> new FacultyNotFoundException("Faculty with id: " + id + "not found!"));
        faculty.setAdmissionOpen(true);
        return facultyRepository.save(faculty);

    }
}
