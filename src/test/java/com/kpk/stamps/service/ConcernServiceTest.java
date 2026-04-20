package com.kpk.stamps.service;

import com.kpk.stamps.dto.CreateConcernRequestDTO;
import com.kpk.stamps.entity.Concern;
import com.kpk.stamps.repository.ConcernRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ConcernServiceTest {

    @Mock
    private ConcernRepository concernRepository;

    @InjectMocks
    private ConcernService concernService;

    @Test
    void shouldCreateConcern(){

        CreateConcernRequestDTO createConcernRequestDTO=new CreateConcernRequestDTO();

        createConcernRequestDTO.setTitle("New Title");


        when(concernRepository.findTopByOrderByIdDesc())
                .thenReturn(Optional.empty());

        when(concernRepository.save(any(Concern.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        Concern concern= concernService.saveConcern(createConcernRequestDTO);

        assertNotNull(concern);
        assertEquals("New Title",concern.getTitle());
        assertEquals("CR-001",concern.getConcernNumber());

        verify(concernRepository,times(1)).save(any(Concern.class));



    }

}
