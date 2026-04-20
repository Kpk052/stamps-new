package com.kpk.stamps.masterdata.service;


import com.kpk.stamps.masterdata.dto.PartDTO;
import com.kpk.stamps.masterdata.dto.ProgramDTO;
import com.kpk.stamps.masterdata.entity.Part;
import com.kpk.stamps.masterdata.entity.Program;
import com.kpk.stamps.masterdata.repository.PartRepository;
import com.kpk.stamps.masterdata.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartService {

    @Autowired
    PartRepository partRepository;

    @Autowired
    ProgramRepository programRepository;

    public Part createPart(Long programId,PartDTO partDTO){
        Program program=programRepository.findById(programId)
                        .orElseThrow(()-> new RuntimeException("Part not found"));

        Part part=new Part();
        part.setPartName(partDTO.getPartName());
        part.setPartNumber(generatePartNumber());
        part.setDescription(partDTO.getDescription());
        part.setStatus(partDTO.getStatus());
        part.setProgram(program);

        partRepository.save(part);

        return part;

    }

    private String generatePartNumber() {

        Optional<Part> lastPart =
                partRepository.findTopByOrderByIdDesc();

        if (lastPart.isEmpty()) {
            return "PA-001";
        }

        String lastNumber = lastPart.get().getPartNumber();
        int number = Integer.parseInt(lastNumber.split("-")[1]);

        return String.format("PA-%03d", number + 1);
    }

    public List<Part> getAllParts(){
        List<Part> parts= partRepository.findAll();

        return parts;
    }

    public Optional<Part> getPartById(Long partId){
        Optional<Part> part=partRepository.findById(partId);

        return part;
    }

    public Part updatePart(Long partId, PartDTO partDTO){

        Part part=partRepository.findById(partId)
                        .orElseThrow(()->new RuntimeException("Part not found"));

        part.setPartName(partDTO.getPartName());
        part.setDescription(partDTO.getDescription());
        part.setStatus(partDTO.getStatus());

        partRepository.save(part);

        return part;
    }

    public void deletePart(Long partId) {
        Part part = partRepository.findById(partId)
                .orElseThrow(() -> new RuntimeException("Part not found"));
        partRepository.delete(part);
    }



}
