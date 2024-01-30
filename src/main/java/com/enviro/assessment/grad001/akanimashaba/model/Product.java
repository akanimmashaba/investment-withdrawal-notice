package com.enviro.assessment.grad001.akanimashaba.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String type; // RETIREMENT/SAVINGS
    private String name;
    private Double currentBalance;

    @ManyToOne
    @JoinColumn(name = "investor_id")
    private Investor investor;

    @OneToMany(mappedBy = "product")
    private List<WithdrawalNotice> withdrawalNotices;

    @OneToMany(mappedBy = "product")
    private List<Statement> statements;

    public Long getInvestorId() {
        return investor != null ? investor.getId() : null;
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
