package com.project.ReDeAmericaBE.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "publication")
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPublication;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "date", nullable = true)
    private Date date;

    @Column(name = "file", nullable = true)
    private String file;

    @OneToMany(mappedBy = "publication", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false)
    private User user;

}
