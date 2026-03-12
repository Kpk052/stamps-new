package com.kpk.stamps.entity;


import com.kpk.stamps.enums.Currency;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name="employees")
public class Employee {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="emp_name")
    private String name;

    @OneToMany(mappedBy = "employee",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Concern concern;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    @CreationTimestamp
    private LocalDateTime dateTime;

    @UpdateTimestamp
    private LocalDateTime updatedTIme;

    @Transient
    private int age;
}
