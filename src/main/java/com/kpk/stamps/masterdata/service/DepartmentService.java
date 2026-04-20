package com.kpk.stamps.masterdata.service;

import com.kpk.stamps.masterdata.entity.Department;
import com.kpk.stamps.masterdata.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    public Department createDepartment(Department department){
        Department department1=new Department();

        department1.setDepartmentName(department.getDepartmentName());
        department1.setDescription(department.getDescription());

        departmentRepository.save(department1);

        return department1;

    }

    public List<Department> getDepartments(){
        List<Department> departments=departmentRepository.findAll();

        return departments;
    }

    public Department updateDepartment(Long departmentId,Department department){
        Department department1=departmentRepository.findById(departmentId)
                .orElseThrow(()->new RuntimeException("Department not found"));

        department1.setDepartmentName(department.getDepartmentName());
        department1.setDescription(department.getDescription());

        departmentRepository.save(department1);

        return department1;

    }

    public void deleteDepartment(Long departmentId){
        departmentRepository.deleteById(departmentId);
    }
}
