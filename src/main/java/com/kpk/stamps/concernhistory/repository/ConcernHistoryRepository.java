package com.kpk.stamps.concernhistory.repository;

import com.kpk.stamps.concernhistory.entity.ConcernHistory;
import com.kpk.stamps.entity.Concern;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConcernHistoryRepository extends JpaRepository<ConcernHistory,Long> {

    Concern getConcernHistoryByConcernId(Long concernId);

    List<ConcernHistory> getByConcernId(Long concernId);

    ConcernHistory getHistoryByConcernId(Long concernId);
}
