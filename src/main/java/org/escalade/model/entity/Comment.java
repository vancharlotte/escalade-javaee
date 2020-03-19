package org.escalade.model.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
@Table(name = "COMMENT")
public class Comment {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "COMMENT_ID")
    private int commentId;
    @NotEmpty
    private String title;
    @NotEmpty
    private String description;
    @NotEmpty
    private int time;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user; //author

    @ManyToOne
    @JoinColumn(name="site_id", nullable=false)
    private Site site;


}
