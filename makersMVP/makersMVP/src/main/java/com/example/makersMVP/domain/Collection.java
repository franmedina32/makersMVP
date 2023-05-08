package com.example.makersMVP.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "collections")
public class Collection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String contractAddress;

    public Collection() {
    }

    public Collection(String name, String contractAddress) {
        this.name = name;
        this.contractAddress = contractAddress;
    }

    public Collection(Long id, String name, String contractAddress) {
        this.id = id;
        this.name = name;
        this.contractAddress = contractAddress;
    }
}
