package org.example.pdp22;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "genre") // Optional: Explicitly specify the table name
public class Genre {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(nullable = false, length = 100)
    private String name;

    // Constructors
    public Genre() {
        // JPA requires a no-arg constructor
    }

    public Genre(String name) {
        this.name = name;
    }

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id; // JPA might need to set this via reflection when fetching from DB
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}