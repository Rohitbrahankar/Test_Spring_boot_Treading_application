package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double coins = 10.0; // default coins

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getCoins() {
        return coins;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoins(Double coins) {
        this.coins = coins;
    }
}
