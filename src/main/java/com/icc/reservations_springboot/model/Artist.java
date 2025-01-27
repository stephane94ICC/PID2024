package com.icc.reservations_springboot.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="artists")
public class Artist {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String lastname;

    @ManyToMany(mappedBy = "artists")
    private List<Type> types = new ArrayList<>();

    public Artist() {}

    public Artist(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Type> getTypes() {
        return types;
    }

    public Artist addType(Type type) {
        if(!this.types.contains(type)) {
            this.types.add(type);
            type.addArtist(this);
        }

        return this;
    }

    public Artist removeType(Type type) {
        if(this.types.contains(type)) {
            this.types.remove(type);
            type.getArtists().remove(this);
        }

        return this;
    }

    @Override
    public String toString() {
        return firstname + " " + lastname;
    }
}
