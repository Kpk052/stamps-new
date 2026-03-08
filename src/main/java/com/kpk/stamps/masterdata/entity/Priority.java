package com.kpk.stamps.masterdata.entity;

import com.kpk.stamps.masterdata.enums.PriorityName;
import jakarta.persistence.*;

@Entity
@Table(name = "priority")
public class Priority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private PriorityName priorityName;

    private Long level;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PriorityName getPriorityName() {
        return priorityName;
    }

    public void setPriorityName(PriorityName priorityName) {
        this.priorityName = priorityName;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }
}
