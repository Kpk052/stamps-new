package com.kpk.stamps.masterdata.dto;

import com.kpk.stamps.masterdata.entity.Department;
import com.kpk.stamps.masterdata.entity.Role;
import com.kpk.stamps.masterdata.enums.Status;
import jakarta.persistence.*;

public class UserDTO {

    private String name;

    private String email;

    private Role role;

    private Status status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
