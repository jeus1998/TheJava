package com.example.springdi;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "TITLE")
    private String title;
}
