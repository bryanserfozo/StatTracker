package com.revature.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    // This class represents our User table and all the associated information with it, so let's add in our properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(unique = true)
    private String username;

    private String password;

    // Annotations for relationships
    @ManyToMany
    @JoinTable(
            name = "users_players",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name="player_id")

    )
    private Set<Player> favorites;

    @Enumerated(EnumType.STRING)
    // This stores the user role in the table as a string, default is a number
    private Role role;

    public User() {
    }

    public User(int userId, String username, String password, Set<Player> favorites, Role role) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.favorites = favorites;
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public Set<Player> getFavorites() {
        return favorites;
    }

    public void setFavorites(Set<Player> favorites) {
        this.favorites = favorites;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
