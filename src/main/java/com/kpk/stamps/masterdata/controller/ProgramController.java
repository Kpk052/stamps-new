package com.kpk.stamps.masterdata.controller;

import com.kpk.stamps.masterdata.dto.ProgramDTO;
import com.kpk.stamps.masterdata.entity.Program;
import com.kpk.stamps.masterdata.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/master")
public class ProgramController {

    @Autowired
    ProgramService programService;

    @PostMapping("/v1/programs")
    public ResponseEntity<Program> createProgram(@RequestBody ProgramDTO programDTO){

        Program program=programService.createProgram(programDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(program);
    }

    @GetMapping("/v1/programs")
    public ResponseEntity<List<Program>> getAllPrograms(){
        List<Program> programs=programService.getAllPrograms();

        return ResponseEntity.ok(programs);
    }

    @GetMapping("/v1/programs/{programId}")
    public ResponseEntity<Program> getProgramById(@PathVariable Long programId){
       Optional<Program> program=programService.getProgramById(programId);

        if(program.isPresent()){
            return ResponseEntity.ok(program.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/v1/programs/{programId}")
    public ResponseEntity<Program> updateProgram(@PathVariable Long programId, @RequestBody ProgramDTO programDTO){
        Program program=programService.updateProgram(programId,programDTO);

            return ResponseEntity.ok(program);

    }

    @DeleteMapping("/v1/programs/{programId}")
    public ResponseEntity<Void> deleteProgram(@PathVariable Long programId){
        programService.deleteProgram(programId);

        return ResponseEntity.ok().build();
    }


}
