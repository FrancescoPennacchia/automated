package com.example.automated.model.user;
import com.example.automated.model.biography.Biography;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@Table(name = "users")
@DiscriminatorValue("users")
public class User implements Serializable, UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private transient Set<Biography> biographies;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Set<Biography> getBiographies() {
        return new HashSet<>(this.biographies);
    }

    public void setBiographies(Set<Biography> biographies) {
        this.biographies = new HashSet<>(biographies);
    }

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException, IOException {
        in.defaultReadObject();
        this.biographies = new HashSet<>();
    }

    public User() {

    }

    public User(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
    }
}
