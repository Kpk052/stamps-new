package com.kpk.stamps.entity;


import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("Prototype")
public class BankService {

    @Transactional
    public void transfer(){
        withdraw();
        deposit();
    }
}
