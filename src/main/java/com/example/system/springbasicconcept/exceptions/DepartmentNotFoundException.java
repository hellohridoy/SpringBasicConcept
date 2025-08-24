package com.example.system.springbasicconcept.exceptions;

import com.example.system.springbasicconcept.entity.Department;

import java.util.List;

public class DepartmentNotFoundException extends Exception {
    public DepartmentNotFoundException(String message) {
        super(message);
    }
}
