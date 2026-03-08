package com.kpk.stamps.masterdata.repository;

import com.kpk.stamps.masterdata.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}
