package com.kpk.stamps.exceptions;

import com.kpk.stamps.entity.Concern;

public class ConcernNotFoundexception extends RuntimeException{
    
    public ConcernNotFoundexception(String message){
        super(message);
    }
}
