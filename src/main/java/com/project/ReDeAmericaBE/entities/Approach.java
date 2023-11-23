package com.project.ReDeAmericaBE.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "approach")
@Data
public class Approach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idApproach;
    @Column(name = "name", nullable = false, length = 45)
    private String name;


}
