package com.kpk.stamps.masterdata.entity;

import com.kpk.stamps.masterdata.enums.RoleName;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private RoleName roleName;
}
