package com.kpk.stamps.masterdata.dto;

import com.kpk.stamps.masterdata.enums.Status;

public class ProgramDTO {
    private String programName;

    private String description;

    private Status status;

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
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
