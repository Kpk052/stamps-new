package com.kpk.stamps.masterdata.repository;

import com.kpk.stamps.masterdata.entity.Priority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriorityRepository extends JpaRepository<Priority,Long> {

}
