package org.escalade.model.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "SITE")
public class Site {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "SITE_ID")
    private int siteId;
    @NotEmpty
    private String name;
    @NotEmpty
    private String location;
    @NotEmpty
    private String description;
    @NotEmpty
    private boolean checked; //Ami de l'escalade


}
