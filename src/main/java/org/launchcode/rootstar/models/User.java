package org.launchcode.rootstar.service.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class User extends AbstractEntity {

    @NotNull
    private String username;

    @NotNull
    private String passwordHash;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.passwordHash = encoder.encode(password); // when we receive a password from the form we will encrypt it and will give it a password and set that value for the passwordHash, this has will be stored in a database
    }


    public String getUsername() {
        return username;
    }

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); // create a new instance of a password encoder


    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, passwordHash);
    }
}
