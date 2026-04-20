package com.kpk.stamps.concernhistory.controller;

import com.kpk.stamps.concernhistory.entity.ConcernHistory;
import com.kpk.stamps.concernhistory.service.ConcernHistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ConcernHistoryController {

    ConcernHistoryService concernHistoryService;

    @GetMapping("/concern/{id}/history")
    public ResponseEntity<ConcernHistory> getHistoryById(Long concernId){
        ConcernHistory concernHistory=concernHistoryService.getHistoryById(concernId);

        return ResponseEntity.ok(concernHistory);
    }

    @GetMapping("/hello")
    public String getHello(){
        return "Hello Pawan";
    }
}
