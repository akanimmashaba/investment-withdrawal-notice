package com.enviro.assessment.grad001.akanimashaba.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "product")
    private Set<Investor> investors = new HashSet<>();

    private String type; // RETIREMENT/SAVINGS
    private String name;
    private Double currentBalance;

    public Set<Investor> getInvestors() {
        return investors;
    }

    public void setInvestors(Set<Investor> investors) {
        this.investors = investors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Double currentBalance) {
        this.currentBalance = currentBalance;
    }
}
