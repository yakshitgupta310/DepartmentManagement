package com.practice.DepartmentManagement.controller;

import com.practice.DepartmentManagement.entity.Department;
import com.practice.DepartmentManagement.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments/id/{Id}")
    public Department getDepartmentbyId(@PathVariable("Id") Long Id){
        return departmentService.getDepartmentById(Id);
    }

    @DeleteMapping("/departments/id/{Id}")
    public String deleteDepartment(@PathVariable("Id") Long Id){
        departmentService.deleteDepartment(Id);
        return "Department with id " + Id + " deleted successfully!";
    }

    @PutMapping("/departments/id/{Id}")
    public Department updateDepartment(@PathVariable("Id") Long Id, @RequestBody Department department){
        return departmentService.updateDepartment(Id, department);
    }

    @GetMapping("/departments/name/{Name}")
    public ArrayList<Department> getDepartmentByName(@PathVariable("Name") String Name){
        return departmentService.getDepartmentByName(Name);
    }
}
