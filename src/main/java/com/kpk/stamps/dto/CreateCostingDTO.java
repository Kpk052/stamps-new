package com.kpk.stamps.dto;

public class CreateCostingDTO {

    private Double materialCost;

    private Double laborCost;

    private Double toolingCost;

    private Double overheadCost;

    private String currency;

    public Double getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(Double materialCost) {
        this.materialCost = materialCost;
    }

    public Double getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(Double laborCost) {
        this.laborCost = laborCost;
    }

    public Double getToolingCost() {
        return toolingCost;
    }

    public void setToolingCost(Double toolingCost) {
        this.toolingCost = toolingCost;
    }

    public Double getOverheadCost() {
        return overheadCost;
    }

    public void setOverheadCost(Double overheadCost) {
        this.overheadCost = overheadCost;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
