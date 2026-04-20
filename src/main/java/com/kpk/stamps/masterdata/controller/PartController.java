package com.kpk.stamps.masterdata.controller;

import com.kpk.stamps.masterdata.dto.PartDTO;
import com.kpk.stamps.masterdata.dto.ProgramDTO;
import com.kpk.stamps.masterdata.entity.Part;
import com.kpk.stamps.masterdata.entity.Program;
import com.kpk.stamps.masterdata.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/master")
public class PartController {

    @Autowired
    PartService partService;

    @PostMapping("/v1/parts/{programId}")
    public ResponseEntity<Part> createPart(@PathVariable Long programId, @RequestBody PartDTO partDTO){
        Part part1=partService.createPart(programId,partDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(part1);

    }

    @GetMapping("/v1/parts")
    public ResponseEntity<List<Part>> getAllParts(){
        List<Part> parts=partService.getAllParts();

        return ResponseEntity.ok(parts);
    }

    @GetMapping("/v1/parts/{partId}")
    public ResponseEntity<Part> getProgramById(@PathVariable Long partId){
        Optional<Part> part=partService.getPartById(partId);

        if(part.isPresent()){
            return ResponseEntity.ok(part.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/v1/parts/{partId}")
    public ResponseEntity<Part> updatePart(@PathVariable Long partId, @RequestBody PartDTO partDTO){
        Part part=partService.updatePart(partId,partDTO);

        return ResponseEntity.ok(part);

    }

    @DeleteMapping("/v1/part/{partId}")
    public ResponseEntity<Void> deletePart(@PathVariable Long partId){
        partService.deletePart(partId);
        return ResponseEntity.ok().build();
    }


}
