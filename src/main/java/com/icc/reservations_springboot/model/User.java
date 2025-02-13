package com.icc.reservations_springboot.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(force = true, access = AccessLevel.PROTECTED)
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String login;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private String langue;

    @Getter
    @Enumerated(EnumType.STRING)
    private UserRole role;

    private LocalDateTime created_at;

    @ManyToMany(mappedBy = "users")
    private List<Role> roles = new ArrayList<>();

    @ManyToMany(mappedBy = "users")
    private List<Representation> representations = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    // Problème avec lombok !
    public String getPassword() {
        return password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public User addRole(Role role) {
        if (!this.roles.contains(role)) {
            this.roles.add(role);
            role.addUser(this);
        }

        return this;
    }

    public User removeRole(Role role) {
        if (this.roles.contains(role)) {
            this.roles.remove(role);
            role.getUsers().remove(this);
        }

        return this;
    }

    public List<Representation> getRepresentations() {
        return representations;
    }

    public User addRepresentation(Representation representation) {
        if (!this.representations.contains(representation)) {
            this.representations.add(representation);
            representation.addUser(this);
        }

        return this;
    }

    public User removeRepresentation(Representation representation) {
        if (this.representations.contains(representation)) {
            this.representations.remove(representation);
            representation.getUsers().remove(this);
        }

        return this;
    }

    @Override
    public String toString() {
        return login + "(" + firstname + " " + lastname + " - " + role + ")";
    }
}
