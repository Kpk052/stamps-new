package com.kpk.stamps.masterdata.service;

import com.kpk.stamps.entity.Concern;
import com.kpk.stamps.masterdata.dto.ProgramDTO;
import com.kpk.stamps.masterdata.entity.Program;
import com.kpk.stamps.masterdata.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgramService {


    @Autowired
    ProgramRepository programRepository;

    public Program createProgram(ProgramDTO programDTO){

        Program program=new Program();

        program.setProgramName(programDTO.getProgramName());
        program.setDescription(programDTO.getDescription());
        program.setStatus(programDTO.getStatus());
        program.setProgramCode(generateProgramCode());

        programRepository.save(program);

        return program;


    }

    private String generateProgramCode() {

        Optional<Program> lastProgram =
                programRepository.findTopByOrderByIdDesc();

        if (lastProgram.isEmpty()) {
            return "PR-001";
        }

        String lastNumber = lastProgram.get().getProgramCode();
        int number = Integer.parseInt(lastNumber.split("-")[1]);

        return String.format("PR-%03d", number + 1);
    }

    public List<Program> getAllPrograms(){
        List<Program> programs= programRepository.findAll();

        return programs;
    }

    public Optional<Program> getProgramById(Long programId){
        Optional<Program> program=programRepository.findById(programId);

        return program;
    }

    public Program updateProgram(Long programId,ProgramDTO programDTO){
        Program program1=programRepository.findById(programId)
                .orElseThrow(()->new RuntimeException("Program Not Found"));

        program1.setProgramName(programDTO.getProgramName());
        program1.setDescription(programDTO.getDescription());
        program1.setStatus(programDTO.getStatus());

        programRepository.save(program1);
        return program1;
    }

    public void deleteProgram(Long programId) {
        Program program = programRepository.findById(programId)
                .orElseThrow(() -> new RuntimeException("Program not found"));

        programRepository.delete(program);
    }



}
