package com.project.ReDeAmericaBE.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;

    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;
    @Column(name = "email", nullable = false, length = 45)
    private String email;
    @Column(name = "password", nullable = false, length = 45)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Publication> publications = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Comment> comments = new HashSet<>();

    public User(String name, String lastName, String email, String password, Role role, Set<Publication> publications, Set<Comment> comments) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.publications = publications;
        this.comments = comments;
    }
}
