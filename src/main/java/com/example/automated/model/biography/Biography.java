package com.example.automated.model.biography;

import com.example.automated.model.user.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import lombok.Data;

@Data
@Entity
@Table(name = "biography")
public class Biography implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "birth_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthDate;

    @Column(name = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        // Return a copy of the user object
        return new User(this.user);
    }
    public void setUser(User user) {
        // Clone the provided User object
        this.user = new User(user);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Biography biography = (Biography) o;
        return Objects.equals(user, biography.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user);
    }

}
