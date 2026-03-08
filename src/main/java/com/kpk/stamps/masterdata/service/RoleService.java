package com.kpk.stamps.masterdata.service;


import com.kpk.stamps.masterdata.entity.Role;
import com.kpk.stamps.masterdata.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {


    @Autowired
    RoleRepository roleRepository;

    public Role createRole(Role role){
        Role role1=roleRepository.save(role);

        return role1;
    }

    public List<Role> getAllRoles(){
        List<Role> roles=roleRepository.findAll();

        return roles;
    }
}
