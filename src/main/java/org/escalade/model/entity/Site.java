package org.escalade.model.entity;

import org.escalade.model.entity.validator.UniqueSite;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity

@Table(name = "SITE")
@UniqueSite
public class Site implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SITE_ID", unique = true)
    private int siteId;

    @NotEmpty
    @Length(max = 50, message = "le titre ne doit pas dépasser 30 caractères.")
    @Column(unique = true)
    private String name;

    @NotEmpty
    private String departement;

    @NotEmpty
    private String city;

    @NotEmpty
    private String quotationMin;

    @NotEmpty
    private String quotationMax;

    @NotEmpty
    private String nbRoutes;

    @NotEmpty
    @Length(min = 10, max = 5000, message = "La description doit être composée de 10 à 500 caractères")
    private String description;

    private boolean checked; //Ami de l'escalade

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    @OneToMany(mappedBy = "site", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments;


    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNbRoutes() {
        return nbRoutes;
    }

    public void setNbRoutes(String nbRoutes) {
        this.nbRoutes = nbRoutes;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getQuotationMin() {
        return quotationMin;
    }

    public void setQuotationMin(String quotationMin) {
        this.quotationMin = quotationMin;
    }

    public String getQuotationMax() {
        return quotationMax;
    }

    public void setQuotationMax(String quotationMax) {
        this.quotationMax = quotationMax;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
