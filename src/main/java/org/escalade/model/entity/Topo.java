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
    private String location;
    @NotEmpty(message = "{NotEmpty.topo.releaseDate}")
    @Column(name = "release_date")
    private String releaseDate;
    private boolean available;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    public int getTopoId() {
        return topoId;
    }

    public void setTopoId(int id) {
        this.topoId = id;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
