package com.kpk.stamps.masterdata.dto;

import com.kpk.stamps.masterdata.entity.Program;
import com.kpk.stamps.masterdata.enums.Status;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class PartDTO {


    private String partName;

    private String description;

    private Status status;

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
