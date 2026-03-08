package com.kpk.stamps.service;

import com.kpk.stamps.concernhistory.service.ConcernHistoryService;
import com.kpk.stamps.dto.ConcernResponseDTO;
import com.kpk.stamps.dto.CreateConcernRequestDTO;
import com.kpk.stamps.dto.UpdateConcernRequestDTO;
import com.kpk.stamps.entity.Concern;
import com.kpk.stamps.enums.ConcernStatus;
import com.kpk.stamps.repository.ConcernRepository;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConcernService {
   @Autowired
    public ConcernRepository concernRepository;

   public ConcernHistoryService concernHistoryService;

    public Concern saveConcern(CreateConcernRequestDTO createConcernRequestDTO) {
        Concern concern = new Concern();

        concern.setAssignedTo(createConcernRequestDTO.getAssignedTo());
        concern.setDescription(createConcernRequestDTO.getDescription());
        concern.setPriority(createConcernRequestDTO.getPriority());
        concern.setInitiatorName(createConcernRequestDTO.getInitiatorName());
        concern.setProgramName(createConcernRequestDTO.getProgramName());
        concern.setRaisedDate(createConcernRequestDTO.getRaisedDate());
        concern.setTargetDate(createConcernRequestDTO.getTargetDate());
        concern.setTitle(createConcernRequestDTO.getTitle());
        concern.setConcernNumber(generateConcernNumber());
        concern.setStatus(ConcernStatus.OPEN);


        concernHistoryService.recordHistory(concern.getId(),"Concern created", "No Status",ConcernStatus.OPEN.name(),createConcernRequestDTO.getAssignedTo());



         return concernRepository.save(concern);
    }

    private String generateConcernNumber() {

                            Optional<Concern> lastConcern =
                concernRepository.findTopByOrderByIdDesc();

        if (lastConcern.isEmpty()) {
            return "CR-001";
        }

        String lastNumber = lastConcern.get().getConcernNumber();
        int number = Integer.parseInt(lastNumber.split("-")[1]);

        return String.format("CR-%03d", number + 1);
    }

    public List<Concern> getAllConcerns(){
        return concernRepository.findAll();
    }

    public Optional<Concern> getConcernById(Long id){
        Optional<Concern> concern=concernRepository.findById(id);

    return concern;
    }

    public Concern updateConcern(Long id, UpdateConcernRequestDTO updateConcernRequestDTO){
         Concern concern=concernRepository.findById(id).orElseThrow(()->new RuntimeException("Concern not found"));

         String oldStatus=concern.getStatus().name();


             concern.setTitle(updateConcernRequestDTO.getTitle());
             concern.setStatus(updateConcernRequestDTO.getStatus());
             concern.setDescription(updateConcernRequestDTO.getDescription());
             concern.setAssignedTo(updateConcernRequestDTO.getAssignedTo());
             concern.setTargetDate(updateConcernRequestDTO.getTargetDate());
             concern.setPriority(updateConcernRequestDTO.getPriority());

             concernRepository.save(concern);

            if(!oldStatus.equals(updateConcernRequestDTO.getStatus().name())){

            }
             concernHistoryService.recordHistory(id,"Status Change",oldStatus,updateConcernRequestDTO.getStatus().name(),updateConcernRequestDTO.getAssignedTo());

         return concern;
    }

    public void deleteById(Long id){
        Concern concern=concernRepository.findById(id).orElseThrow(()->new RuntimeException("Concern Not Found"));

        concernRepository.delete(concern);
    }
}