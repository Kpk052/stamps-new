package com.kpk.stamps.masterdata.repository;

import com.kpk.stamps.masterdata.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
