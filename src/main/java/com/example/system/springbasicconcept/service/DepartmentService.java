package com.example.system.springbasicconcept.service;

import com.example.system.springbasicconcept.entity.Department;
import com.example.system.springbasicconcept.exceptions.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {

    Department saveDepartment(Department department);


    List<Department> fatehAllDepartments();

    Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    Department updateDepartment(Department department, Long departmentId);

    Department fetchDepartmentByName(String departmentName);
}
