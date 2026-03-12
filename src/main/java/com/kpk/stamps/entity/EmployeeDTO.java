package com.kpk.stamps.entity;

import com.kpk.stamps.enums.Currency;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class EmployeeDTO {

    @NotBlank
    private String name;

    @NotEmpty
    private Currency currency;
}
