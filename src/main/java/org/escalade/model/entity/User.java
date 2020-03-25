package org.escalade.model.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "USERS")

public class User implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private int userId;
    @NotEmpty(message = "{NotEmpty.user.username}")
    private String username;
    @NotEmpty(message = "NotEmpty.user.password")
    private String password;
    @Transient
    private String confirmPassword;
    @NotEmpty(message = "NotEmpty.user.email")
    @Email (message = "{Email.user.email}")
    private String email;

    @OneToMany(mappedBy="user")
    private Set<Topo> site;

    @OneToMany(mappedBy="user")
    private Set<Topo> topo;

    @OneToMany(mappedBy="user")
    private Set<Comment> comment;

    //private String role;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="role_id")
    private Role role ;



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
