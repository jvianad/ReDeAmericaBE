package com.project.ReDeAmericaBE.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "country")
@Data
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPais;

    @Column(name = "name", nullable = false, length = 45)
    private String name;
}
