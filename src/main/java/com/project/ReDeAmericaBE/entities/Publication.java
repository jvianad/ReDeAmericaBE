package com.project.ReDeAmericaBE.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
    @Column(name = "title", nullable = false, length = 45)
    private String title;
    @Column(name = "content", nullable = false)
    private String content;
    /*@Column(name = "file", nullable = true)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Lob()
    private byte [] file; */
    @Column(name = "date", nullable = true)
    private String date;

    @OneToMany(mappedBy = "publication", cascade = CascadeType.ALL)
    private Set<Approach> approaches = new HashSet<>();

    @OneToMany(mappedBy = "publication", cascade = CascadeType.ALL)
    private Set<Comment> comments = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "idCountry", nullable = true)
    private Country country;

}
