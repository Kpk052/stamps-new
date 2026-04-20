package com.kpk.stamps.masterdata.repository;

import com.kpk.stamps.masterdata.entity.Part;
import com.kpk.stamps.masterdata.entity.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartRepository extends JpaRepository<Part,Long> {
    Optional<Part> findTopByOrderByIdDesc();
}
