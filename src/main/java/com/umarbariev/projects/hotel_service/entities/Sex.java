package com.umarbariev.projects.hotel_service.entities;

import javax.persistence.*;

@Entity
@Table(name = "sex")
public class Sex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sex_id")
    private int id;
    @Column(name = "sex_name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
