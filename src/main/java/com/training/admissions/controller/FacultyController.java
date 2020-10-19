package com.training.admissions.controller;


import com.training.admissions.dto.FacultyDTO;
import com.training.admissions.entity.Faculty;
import com.training.admissions.service.FacultyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Slf4j
@Controller

public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }


    @GetMapping("/faculties")
    public String getAllFaculties(@PageableDefault(sort = {"nameEn"}, direction = Sort.Direction.ASC, size = 5) Pageable pageable,
                                  @AuthenticationPrincipal User user, Model model) {

        if (user.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"))) {
            return "redirect:/admin/workspace";
        } else {
            Page<Faculty> page = facultyService.getAllFaculties(pageable);
            model.addAttribute("page", page);
            model.addAttribute("url", "/faculties");
            return "faculties";
        }
    }


    @GetMapping("/admin/faculty/add")
    public String createNewFacultyForm(Model model) {
        return "/admin/create-faculty";
    }

    @PostMapping("/admin/faculty/add")
    public String createNewFaculty(@Valid FacultyDTO facultyDTO,
                                   BindingResult bindingResult,
                                   Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("faculty", facultyDTO);
            model.addAttribute("errorMessages", bindingResult.getAllErrors());
            return "/admin/create-faculty";
        }
        facultyService.createFaculty(facultyDTO);

        return "redirect:/admin/workspace";
    }


    @PostMapping("/admin/block_reg/{id}")
    public String blockRegistrationToFaculty(FacultyDTO facultyDTO) {
        facultyService.blockUnblockRegistration(facultyDTO);
        return "redirect:/admin/workspace";
    }


    @GetMapping("/admin/faculty/edit/{id}")
    public String editFacultyWithId(@PathVariable Long id, Model model) {
        model.addAttribute("faculty", facultyService.getById(id));
        return "/admin/edit-faculty";

    }


    @PostMapping("/admin/faculty/edit/{id}")
    public String updateFacultyWithId(FacultyDTO facultyDTO) {
        facultyService.createFaculty(facultyDTO);
        return "redirect:/admin/workspace";

    }


    @PostMapping("/admin/faculties/delete/{id}")
    public String deleteFacultyById(@PathVariable(name = "id") Long id) {
        facultyService.deleteById(id);
        return "redirect:/admin/workspace";
    }


    @GetMapping("/admin/workspace")
    public String getAdminWorkspace(@PageableDefault(sort = {"nameEn"}, direction = Sort.Direction.ASC, size = 5) Pageable pageable,
                                    Model model) {

        Page<Faculty> page = facultyService.getAllFaculties(pageable);
        model.addAttribute("page", page);
        model.addAttribute("url", "/admin/workspace");
        return "/admin/admin_workspace";

    }

}
