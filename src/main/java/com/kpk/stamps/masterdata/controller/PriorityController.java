package com.kpk.stamps.masterdata.controller;

import com.kpk.stamps.masterdata.entity.Priority;
import com.kpk.stamps.masterdata.service.PriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/master")
public class PriorityController {

    @Autowired
    PriorityService priorityService;

    @PostMapping("/v1/priority")
    public ResponseEntity<Priority> createPriority(@RequestBody Priority priority){

        Priority priority1=priorityService.createPriority(priority);

        return ResponseEntity.status(HttpStatus.CREATED).body(priority1);
    }

    @GetMapping("/v1/priority")
    public ResponseEntity<List<Priority>> getAllPriorities(){
        List<Priority> priorities=priorityService.getAllPriorities();

        return ResponseEntity.ok(priorities);
    }

    @PutMapping("/v1/priority/{priorityId}")
    public ResponseEntity<Priority> updatePriority(@PathVariable Long priorityId,@RequestBody Priority priority){
        Priority priority1=priorityService.updatePriority(priorityId,priority);

        return ResponseEntity.ok(priority);
    }

    @DeleteMapping("/v1/priority/{priorityId}")
    public ResponseEntity<Void> deletePriority(@PathVariable Long priorityId){
        priorityService.deletePriority(priorityId);

        return ResponseEntity.ok().build();
    }

}
