package me.mikkalmc.login.model;

import java.util.Set;

import javax.persistence.CascadeType;

// TODO: add one to many relationship

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Data
@Table(name="user")
@Entity
public class ApplicationUser {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name = "user_id")
    public Integer id;

    @NotEmpty(message = "Please provide username")
    @Column(name = "username")
    private String username;

    @NotEmpty(message = "Please provide password")
    @Column(name = "password")
    private String password;

    protected ApplicationUser() {}

    public ApplicationUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}