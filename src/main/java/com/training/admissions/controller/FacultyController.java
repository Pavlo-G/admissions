package com.training.admissions.controller;

import com.training.admissions.dto.FacultyDTO;
import com.training.admissions.model.Faculty;
import com.training.admissions.service.FacultyService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/faculty")
public class FacultyController {

private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }


    @GetMapping
        public List<Faculty> getAll() {

            return facultyService.getAllFaculties();
        }

        @GetMapping("/{id}")
        @PreAuthorize("hasAuthority('candidates:read')")
        public Faculty getById(@PathVariable Long id)  {

            return facultyService.getById(id);

        }


        @PostMapping
        @PreAuthorize("hasAuthority('admins:edit')")
        public Faculty create(@RequestBody FacultyDTO facultyDTO) {
            return facultyService.createFaculty(facultyDTO);
        }


        @DeleteMapping("/{id}")
        @PreAuthorize("hasAuthority('admins:edit')")
        public void deleteById(Long id) {
            facultyService.deleteById(id);
        }

}
