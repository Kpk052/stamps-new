package com.kpk.stamps.entity;

import com.kpk.stamps.enums.Currency;
import jakarta.persistence.*;

@Entity
@Table(name="costings")
public class Costing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double materialCost;

    private Double laborCost;

    private Double toolingCost;

    private Double overheadCost;

    private Double totalCost;

    private Currency currency;

    @OneToOne
    @JoinColumn(name="concern_id")
    private Concern concern;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Concern getConcern() {
        return concern;
    }

    public void setConcern(Concern concern) {
        this.concern = concern;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }
}
