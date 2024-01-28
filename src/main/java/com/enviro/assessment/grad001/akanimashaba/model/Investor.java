package com.enviro.assessment.grad001.akanimashaba.model;


import jakarta.persistence.*;

@Entity
@Table(name = "investors")
public class Investor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String contactNumber;
    private int age;

}
