package com.project.ReDeAmericaBE.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Lob()
    private byte[] file;

    @ManyToOne
    @JoinColumn(name = "idPublication", nullable = false)
    private Publication publication;
    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false)
    private User user;
}
