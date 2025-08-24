package com.example.system.springbasicconcept.service;

import com.example.system.springbasicconcept.entity.Department;
import com.example.system.springbasicconcept.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = DepartmentServiceTest.class)
class DepartmentServiceTest {

    private final DepartmentService departmentService;

    private final DepartmentRepository departmentRepository;

    DepartmentServiceTest(DepartmentService departmentService, DepartmentRepository departmentRepository) {
        this.departmentService = departmentService;
        this.departmentRepository = departmentRepository;
    }

    @BeforeEach
    void setUp() {
    }

    @Test
    public void whenValidDepartmentName_thenDepartmentShouldBeFound() {
        String name = "Department Name";
        Department found = departmentService.fetchDepartmentByName(name);
        assertEquals(name,found.getDepartmentName());
    }
}