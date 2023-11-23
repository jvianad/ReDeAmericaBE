package com.project.ReDeAmericaBE.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "publication")
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPublication;
    @Column(name = "title", nullable = false, length = 45)
    private String title;
    @Column(name = "content", nullable = false)
    private String content;
    @Column(name = "file", nullable = false)
    private byte [] file;
    @Column(name = "date", nullable = false)
    private Date date;
}
