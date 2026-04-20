package com.kpk.stamps.concernhistory.service;


import com.kpk.stamps.concernhistory.entity.ConcernHistory;
import com.kpk.stamps.concernhistory.repository.ConcernHistoryRepository;
import com.kpk.stamps.entity.Concern;
import com.kpk.stamps.repository.ConcernRepository;
import com.kpk.stamps.service.ConcernService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConcernHistoryService {



    @Autowired
    ConcernHistoryRepository concernHistoryRepository;

    @Autowired
   ConcernRepository concernRepository;

    public void recordHistory(Long concernId, String action, String oldValue, String newValue, String changedBy){
        Concern concern=concernRepository.findById(concernId)
                .orElseThrow(()-> new RuntimeException("concern not found"));

        ConcernHistory concernHistory1=new ConcernHistory();

        concernHistory1.setAction(action);
        concernHistory1.setOldValue(oldValue);
        concernHistory1.setNewValue(newValue);
        concernHistory1.setChangedBy(changedBy);
        concernHistory1.setConcern(concern);
        concernHistoryRepository.save(concernHistory1);
    }

    public List<ConcernHistory> getByConcernId(Long concernId){
     List<ConcernHistory> concernHistories=concernHistoryRepository.getByConcernId(concernId);

     return concernHistories;
    }

    public ConcernHistory getHistoryById(Long conernId){
        ConcernHistory concernHistory1=concernHistoryRepository.getHistoryByConcernId(conernId);

        return concernHistory1;
    }
}
