package com.example.system.springbasicconcept.repository;

import com.example.system.springbasicconcept.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    
    public Department findByDepartmentName(String departmentName);

    public Department    findByDepartmentNameContainingIgnoreCase(String departmentName);

    Department findDistinctByDepartmentName(String departmentName);
}
