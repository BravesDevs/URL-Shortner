package com.dev.url_shortner.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user", uniqueConstraints = {@jakarta.persistence.UniqueConstraint(columnNames = "email")})
public class User {

    @Id
    private String email;

    public String getEmail() {
        return email;
    }

    public User(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                '}';
    }

    public User() {
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
