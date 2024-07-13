package org.example.pdp22;

import jakarta.persistence.*;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;

    // constructors, getters, setters
}
