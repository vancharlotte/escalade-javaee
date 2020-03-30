package org.escalade.model.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TOPO")
public class Topo implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "TOPO_ID")
    private int topoId;
    @NotEmpty(message = "{NotEmpty.topo.name}")
    @Length(max = 20, message = "{Length.topo.name}")
    private String name;
    @NotEmpty(message = "{NotEmpty.topo.description}")
    @Length(min = 10, max = 200, message = "{Length.topo.description}")
    private String description;
    @NotEmpty(message = "{NotEmpty.topo.location}")
    private String city;
    @NotEmpty(message = "{NotEmpty.topo.location}")
    private String departement;
    @NotEmpty(message = "{NotEmpty.topo.releaseDate}")
    @Column(name = "release_date")
    private String releaseDate;
    private boolean available;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    public int getTopoId() {
        return topoId;
    }

    public void setTopoId(int topoId) {
        this.topoId = topoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
