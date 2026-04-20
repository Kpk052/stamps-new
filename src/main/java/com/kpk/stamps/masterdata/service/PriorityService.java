package com.kpk.stamps.masterdata.service;


import com.kpk.stamps.masterdata.entity.Priority;
import com.kpk.stamps.masterdata.repository.PartRepository;
import com.kpk.stamps.masterdata.repository.PriorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriorityService {

    @Autowired
    PriorityRepository priorityRepository;


    public Priority createPriority(Priority priority){
        Priority priority1=new Priority();

        priority1.setPriorityName(priority.getPriorityName());
        priority1.setLevel(priority.getLevel());
        priorityRepository.save(priority1);

        return priority1;
    }

    public List<Priority> getAllPriorities(){
        List<Priority> priorities=priorityRepository.findAll();

        return priorities;
    }

    public Priority updatePriority(Long priorityId,Priority priority){
        Priority priority1=priorityRepository.findById(priorityId)
                .orElseThrow(()->new RuntimeException("Priority not found"));

        priority1.setPriorityName(priority.getPriorityName());
        priority1.setLevel(priority.getLevel());

        priorityRepository.save(priority1);

        return priority1;
    }

    public void deletePriority(Long priorityId){
        priorityRepository.deleteById(priorityId);
    }
}
