package com.project.ReDeAmericaBE.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "approach")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Approach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idApproach;
    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @ManyToOne
    @JoinColumn(name = "idPublication", nullable = false)
    private Publication publication;

}
