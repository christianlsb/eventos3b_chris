package br.com.spliteventos.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100)
    @NotNull
    @Column(unique = true)
    private String username;

    @Size(max = 100)
    @NotNull
    @Column(name = "user_password")
    private String user_password;

    @Size(max = 100)
    @NotNull
    @Column(unique = true)
    private String email;

    @ManyToMany
    @JoinTable(
            name = "role_user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> permissions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public List<Role> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Role> permissions) {
        this.permissions = permissions;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + user_password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
