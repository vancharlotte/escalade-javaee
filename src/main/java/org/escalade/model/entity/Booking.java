package org.escalade.model.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "BOOKING")
public class Booking {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "BOOKING_ID")
    private int bookingId;
    @NotEmpty
    private String status;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user; // the one who do the request

    @ManyToOne
    @JoinColumn(name="topo_id", nullable=false)
    private Topo topo;


}
