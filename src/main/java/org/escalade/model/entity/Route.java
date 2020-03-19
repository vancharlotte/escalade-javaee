package org.escalade.model.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "ROUTE")
public class Route {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ROUTE_ID")
    private int routeId;
    @NotEmpty
    private String name;
    @NotEmpty
    private int quotation;

    @ManyToOne
    @JoinColumn(name="sector_id", nullable=false)
    private Sector sector;  //fait parti d'un sector

}
