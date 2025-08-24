package com.example.system.springbasicconcept.service;

import com.example.system.springbasicconcept.entity.Department;
import com.example.system.springbasicconcept.exceptions.DepartmentNotFoundException;
import com.example.system.springbasicconcept.repository.DepartmentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fatehAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(departmentId);
        if (department.isEmpty()) {
           throw new DepartmentNotFoundException("Department not available");
        }
        return department.get();
    }

    @Override
    public Department updateDepartment(Department existingDepartment, Long departmentId) {
        Department department = departmentRepository.findById(departmentId).get();

        if (Objects.nonNull(existingDepartment.getDepartmentName()) &&
                !"".equalsIgnoreCase(existingDepartment.getDepartmentName())) {
            department.setDepartmentName(existingDepartment.getDepartmentName());
        }

        if (Objects.nonNull(existingDepartment.getDepartmentCode()) &&
                !"".equalsIgnoreCase(existingDepartment.getDepartmentCode())) {
            department.setDepartmentCode(existingDepartment.getDepartmentCode());
        }

        if (Objects.nonNull(existingDepartment.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(existingDepartment.getDepartmentAddress())) {
            department.setDepartmentAddress(existingDepartment.getDepartmentAddress());
        }

        return departmentRepository.save(department);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }
}
