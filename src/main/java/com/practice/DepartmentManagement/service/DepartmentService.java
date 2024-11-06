package com.practice.DepartmentManagement.service;

import com.practice.DepartmentManagement.entity.Department;

import java.util.ArrayList;

public interface DepartmentService {

    public Department saveDepartment(Department department);

    public Department getDepartmentById(Long Id);

    public void deleteDepartment(Long Id);

    public Department updateDepartment(Long Id, Department department);

    public ArrayList<Department> getDepartmentByName(String Name);
}
