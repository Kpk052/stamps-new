package com.kpk.stamps.controller;

import com.kpk.stamps.dto.CreateCostingDTO;
import com.kpk.stamps.entity.Concern;
import com.kpk.stamps.entity.Costing;
import com.kpk.stamps.service.CostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CostingController {

    @Autowired
    CostingService costingService;

    @PostMapping("/v1/costing/{concernId}")
    public ResponseEntity<Costing> createCosting(@PathVariable Long concernId, @RequestBody CreateCostingDTO createCostingDTO){
         Costing costing=costingService.createCosting(concernId,createCostingDTO);

         return ResponseEntity.status(HttpStatus.CREATED).body(costing);
    }

    @GetMapping("/v1/costing")
    public ResponseEntity<List<Costing>> getAllCosting(){
        List<Costing> costing= costingService.getALlCostings();

        return ResponseEntity.status(HttpStatus.OK).body(costing);
    }

    @GetMapping("/v1/costing/{concernId}")
    public ResponseEntity<Costing> getCosting(@PathVariable Long concernId){
        Optional<Costing> costing=costingService.getCostingById(concernId);

        if(costing.isPresent()){
            return ResponseEntity.ok(costing.get());
        }
        return ResponseEntity.notFound().build();
    }

}
