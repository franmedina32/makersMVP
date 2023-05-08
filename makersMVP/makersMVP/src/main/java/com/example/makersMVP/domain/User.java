package com.example.makersMVP.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userEmail;
    private String password;

    @ManyToMany
    @JoinTable(
            name = "user_collection",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "collection_id")
    )
    private Set<Collection> favCollections;

    public User() {
    }

    public User(String userEmail, String password) {
        this.userEmail = userEmail;
        this.password = password;
    }

    public User(Long id, String userEmail, String password, Set<Collection> favCollections) {
        this.id = id;
        this.userEmail = userEmail;
        this.password = password;
        this.favCollections = favCollections;
    }

    public User(String userEmail, String password, Set<Collection> favCollections) {
        this.userEmail = userEmail;
        this.password = password;
        this.favCollections = favCollections;
    }

    public void addFav(Collection collection) {
        favCollections.add(collection);
    }

    public void deleteFav(Collection collection) {
        favCollections.remove(collection);
    }
}
