package com.kpk.stamps.masterdata.controller;


import com.kpk.stamps.masterdata.entity.Department;
import com.kpk.stamps.masterdata.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/master")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping("/v1/department")
    public ResponseEntity<Department> createDepartment(@RequestBody Department department){
        Department department1=departmentService.createDepartment(department);

        return ResponseEntity.status(HttpStatus.CREATED).body(department);
    }

    @GetMapping("/v1/department")
    public ResponseEntity<List<Department>> getDepartments(){
        List<Department> departments=departmentService.getDepartments();

        return ResponseEntity.ok(departments);
    }

    @PutMapping("/v1/department/{departmentId}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long departmentId, @RequestBody Department department){

        Department department1=departmentService.updateDepartment(departmentId,department);

        return ResponseEntity.status(HttpStatus.OK).body(department1);

    }

    @DeleteMapping("/v1/department/{departmentId}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long departmentId){
        departmentService.deleteDepartment(departmentId);

        return ResponseEntity.ok().build();
    }

}
