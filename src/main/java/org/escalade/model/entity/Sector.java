package org.escalade.model.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "SECTOR")
public class Sector {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "SECTOR_ID")
    private int sectorId;
    @NotEmpty
    private String name;

    @ManyToOne
    @JoinColumn(name="site_id", nullable=false)
    private Site site;  //fait parti d'un site
}
