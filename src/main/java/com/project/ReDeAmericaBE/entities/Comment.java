package com.project.ReDeAmericaBE.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Date;

@Entity
@Data
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idComment;
    @Column(name = "content", nullable = false)
    private String content;
    @Column(name = "date", nullable = false)
    private Date date;
    @Column(name = "file", nullable = false)
    private byte[] file;

}
