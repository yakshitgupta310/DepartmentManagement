package com.practice.DepartmentManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;
    private String departmentName;
    private String departmentAddress;
    private int departmentCode;

    public Department(Long Id, String Name, String Address, int Code){
        this.departmentCode = Code;
        this.departmentAddress = Address;
        this.departmentId = Id;
        this.departmentName = Name;
    }

    public Department(){}

    public Long getDepartmentId(){
        return this.departmentId;
    }

    public void setDepartmentId(Long id){
        this.departmentId = id;
    }

    public String getDepartmentName(){
        return this.departmentName;
    }

    public void setDepartmentName(String Name){
        this.departmentName = Name;
    }

    public String getDepartmentAddress(){
        return this.departmentAddress;
    }

    public void setDepartmentAddress(String Address){
        this.departmentAddress = Address;
    }

    public int getDepartmentCode(){
        return this.departmentCode;
    }

    public void setDepartmentCode(int Code){
        this.departmentCode = Code;
    }

    public String ToString(){
        return "Department{" + this.departmentName + " " + this.departmentCode + " " + this.departmentId + " " + this.departmentAddress;
    }
}
