package com.practice.DepartmentManagement.service;

import com.practice.DepartmentManagement.entity.Department;
import com.practice.DepartmentManagement.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department){
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(Long Id){
        return departmentRepository.findById(Id).get();
    }

    @Override
    public void deleteDepartment(Long Id){
         departmentRepository.deleteById(Id);
    }

    @Override
    public Department updateDepartment(Long Id, Department department){
        Department updateddepartment = departmentRepository.findById(Id).get();
        if(Objects.nonNull(department.getDepartmentCode()) && !"".equals(department.getDepartmentCode())){
            updateddepartment.setDepartmentCode(department.getDepartmentCode());
        }

        if(Objects.nonNull(department.getDepartmentName()) && !"".equals(department.getDepartmentName())){
            updateddepartment.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equals(department.getDepartmentAddress())){
            updateddepartment.setDepartmentAddress(department.getDepartmentAddress());
        }
        departmentRepository.save(updateddepartment);
        return updateddepartment;

    }

    @Override
    public ArrayList<Department> getDepartmentByName(String Name){
        ArrayList<Department> departments = new ArrayList<Department>();
        List<Department> sortDepartments = departmentRepository.findAll();

        for(Department db : sortDepartments){
            if(db.getDepartmentName().equals(Name)){
                departments.add(db);
            }
        }

        return departments;

    }
}
