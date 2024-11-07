package com.practice.DepartmentManagement.controller;

import com.practice.DepartmentManagement.entity.Department;
import com.practice.DepartmentManagement.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside Post Request for creating Department");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments/id/{Id}")
    public Department getDepartmentbyId(@PathVariable("Id") Long Id){
        LOGGER.info("Inside Get Request for fetching Department By Id");
        return departmentService.getDepartmentById(Id);
    }

    @DeleteMapping("/departments/id/{Id}")
    public String deleteDepartment(@PathVariable("Id") Long Id){
        LOGGER.info("Inside Delete Request for delete Department By Id");
        departmentService.deleteDepartment(Id);
        return "Department with id " + Id + " deleted successfully!";
    }

    @PutMapping("/departments/id/{Id}")
    public Department updateDepartment(@PathVariable("Id") Long Id, @RequestBody Department department){
        LOGGER.info("Inside Put Request for updating Department By Id");
        return departmentService.updateDepartment(Id, department);
    }

    @GetMapping("/departments/name/{Name}")
    public ArrayList<Department> getDepartmentByName(@PathVariable("Name") String Name){
        LOGGER.info("Inside Get Request for fetching Department By DepartmentName");
        return departmentService.getDepartmentByName(Name);
    }
}
