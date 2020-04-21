package org.escalade.model.entity;

import org.escalade.model.entity.validator.CompareStrings;
import org.escalade.model.entity.validator.UniqueEmail;
import org.escalade.model.entity.validator.UniqueUser;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "USERS")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private int userId;

    @UniqueUser(message = "Cet identifiant est déjà utilisé")
    @NotEmpty(message = "Entrez un identifiant")
    @Column(unique = true)
    private String username;

    @NotEmpty(message = "Entrez un mot de passe")
    @Length(min = 8, message = "Votre mot de passe doit être composé d'au moins 8 caractères")
    private String password;

    @Transient
    private String confirmPassword;

    @UniqueEmail(message = "Cette adresse email est  déjà utilisé")
    @NotEmpty(message = "Veuillez saisir une adresse email valide")
    @Email(message = "Veuillez saisir une adresse email valide")
    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "user")
    private Set<Topo> site;

    @OneToMany(mappedBy = "user")
    private Set<Topo> topo;

    @OneToMany(mappedBy = "user")
    private Set<Comment> comment;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int id) {
        this.userId = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<Topo> getSite() {
        return site;
    }

    public void setSite(Set<Topo> site) {
        this.site = site;
    }

    public Set<Topo> getTopo() {
        return topo;
    }

    public void setTopo(Set<Topo> topo) {
        this.topo = topo;
    }

    public Set<Comment> getComment() {
        return comment;
    }

    public void setComment(Set<Comment> comment) {
        this.comment = comment;
    }
}
