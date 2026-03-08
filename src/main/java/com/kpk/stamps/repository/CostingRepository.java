package com.kpk.stamps.repository;

import com.kpk.stamps.entity.Costing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostingRepository extends JpaRepository<Costing,Long> {
}
