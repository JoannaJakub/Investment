package pl.coderslab.springboot.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Component
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Email(message = "Please enter correct email format.")
    @NotEmpty(message = "Please enter your email.")
    @Column(nullable = false,  length = 45)
    private String username;
    @NotBlank(message = "Please enter your password.")
    @Column(nullable = false, length = 64)
    private String password;
    @NotEmpty(message = "Please enter your name.")
    @Column(name = "firstname", nullable = false, length = 20)
    private String firstName;
    @NotBlank(message = "Please enter your surname.")
    @Column(name = "lastname", nullable = false, length = 20)
    private String lastName;

   @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles  = new HashSet<>();
    public User(String username, String password, Collection<? extends GrantedAuthority> authorities) {
    }

    private boolean enabled;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_storage", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "storage_id"))
    private Set<Storage> storage  = new HashSet<>();

}

