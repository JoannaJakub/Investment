package pl.coderslab.springboot;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.coderslab.springboot.model.User;

import java.util.Collection;

public class CurrentUser extends User implements UserDetails {
    private final pl.coderslab.springboot.model.User user;
    public CurrentUser(String username, String password,
                       Collection<? extends GrantedAuthority> authorities,
                       pl.coderslab.springboot.model.User user) {
        super(username,password,authorities);
        this.user = user;
    }
    public pl.coderslab.springboot.model.User getUser() {return user;}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}