package com.example.system.springbasicconcept.controller;

import com.example.system.springbasicconcept.entity.Department;
import com.example.system.springbasicconcept.exceptions.DepartmentNotFoundException;
import com.example.system.springbasicconcept.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DepartmentRestController {

    private final DepartmentService departmentService;

    @PostMapping("/api/v1/departments/department-infos")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        log.info("Saving Department Info");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/api/v1/departments/department-infos")
    public List<Department> fetchAllDepartments() {
        log.info("Fetching all Department Info");
        return departmentService.fatehAllDepartments();
    }

    @GetMapping("/api/v1/departments/department-infos/{departmentId}")
    public Department fetchDepartmentById(@PathVariable Long departmentId)
            throws DepartmentNotFoundException {
        log.info("Fetching Department Info by ID: {}", departmentId);
        return departmentService.fetchDepartmentById(departmentId);
    }

    @PutMapping("/api/v1/departments/department-infos/{departmentId}")
    public Department updateDepartment(@RequestBody Department department, @PathVariable Long departmentId) {
        log.info("Updating Department Info for ID: {}", departmentId);
        return departmentService.updateDepartment(department, departmentId);
    }

    @GetMapping("/api/v1/departments/department-infos/by-name")
    public Department fetchDepartmentByName(
            @RequestParam String departmentName) {
        log.info("Fetching Department Info by Name: {}", departmentName);
        return departmentService.fetchDepartmentByName(departmentName);
    }
}
