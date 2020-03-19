package org.escalade.model.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ROLE")
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ROLE_ID")
    private int roleId;
    @NotEmpty
    private String name;

    @OneToMany(mappedBy="role")
    private Set<User> users;
}
