package com.bloggertime.nowblog.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description", nullable = false, length = 100)
    private String description;

    @Column(name = "longitude", nullable = false)
    private double longitude;

    @Column(name = "latitude", nullable = false)
    private double latitude;

    @Column(name = "points", nullable = false)
    private int points;

    @Column(name = "is_active", nullable = true)
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    @JsonManagedReference
    private User owner;

    @ManyToOne
    @JoinColumn(name = "finder_id", nullable = true)
    private User finder;


    public Post(long id, String name, String description, User owner, int points, boolean isActive) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.owner = owner;
        this.points = points;
        this.isActive = isActive;
    }

    public Post(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        }


    public Post() {}


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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



    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

}
