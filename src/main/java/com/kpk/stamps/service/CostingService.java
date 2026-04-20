package com.kpk.stamps.service;


import com.kpk.stamps.concernhistory.service.ConcernHistoryService;
import com.kpk.stamps.dto.CreateConcernRequestDTO;
import com.kpk.stamps.dto.CreateCostingDTO;
import com.kpk.stamps.entity.Concern;
import com.kpk.stamps.entity.Costing;
import com.kpk.stamps.enums.Currency;
import com.kpk.stamps.repository.ConcernRepository;
import com.kpk.stamps.repository.CostingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CostingService {

    @Autowired
    ConcernRepository concernRepository;
    @Autowired
    CostingRepository costingRepository;

    public ConcernHistoryService concernHistoryService;

    public Costing createCosting(Long concernId, CreateCostingDTO createCostingDTO){
        Concern concern= concernRepository.findById(concernId)
                .orElseThrow(()->new RuntimeException("Concern not found"));

        Costing costing=new Costing();

        costing.setLaborCost(createCostingDTO.getLaborCost());
        costing.setMaterialCost(createCostingDTO.getMaterialCost());
        costing.setOverheadCost(createCostingDTO.getOverheadCost());
        costing.setToolingCost(createCostingDTO.getToolingCost());

        Double totalCost= createCostingDTO.getLaborCost()+createCostingDTO.getMaterialCost()+createCostingDTO.getOverheadCost()+createCostingDTO.getToolingCost();

        costing.setTotalCost(totalCost);
        costing.setCurrency(Currency.INR);
        costing.setConcern(concern);

        costingRepository.save(costing);


        concernHistoryService.recordHistory(concernId,"new Cost","No Cost",createCostingDTO.getToolingCost().toString(),concern.getAssignedTo());

        return costing;
    }

    public List<Costing> getALlCostings(){
        List<Costing> costings=costingRepository.findAll();

        return costings;
    }

    public Optional<Costing> getCostingById(Long concernId){
        Optional<Costing> costing=costingRepository.findById(concernId);

        return costing;
    }
}
