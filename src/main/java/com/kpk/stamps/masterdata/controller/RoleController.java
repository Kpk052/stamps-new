package com.kpk.stamps.masterdata.controller;


import com.kpk.stamps.masterdata.entity.Role;
import com.kpk.stamps.masterdata.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/master")
public class RoleController {

    RoleService roleService;

    @PostMapping("/v1/roles")
    public ResponseEntity<Role> createRole(@RequestBody Role role){
        Role role1=roleService.createRole(role);

        return ResponseEntity.status(HttpStatus.CREATED).body(role1);

    }

    @GetMapping("/v1/roles")
    public ResponseEntity<List<Role>> getRoles(){
        List<Role> roles=roleService.getAllRoles();

        return ResponseEntity.ok(roles);
    }
}
