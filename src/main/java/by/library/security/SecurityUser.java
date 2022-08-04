package by.library.security;

import by.library.model.Role;
import by.library.model.Status;
import by.library.model.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class SecurityUser implements UserDetails {

    private final java.lang.String login;
    private final java.lang.String password;
    private final boolean isActive;
    private final List<SimpleGrantedAuthority> authorities;

    public SecurityUser(java.lang.String login, java.lang.String password, boolean isActive, List<SimpleGrantedAuthority> authorities) {
        this.login = login;
        this.password = password;
        this.isActive = isActive;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public java.lang.String getPassword() {
        return password;
    }

    @Override
    public java.lang.String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }

    public static Set<SimpleGrantedAuthority> getAuthority(Set<Role> roles) {

        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName()))
                .collect(Collectors.toSet());
    }

    public static boolean isActive(Status status) {

        return status.getName().equals("ACTIVE");
    }

    public static UserDetails fromUser(User user){
        return new org.springframework.security.core.userdetails.User(
                user.getLogin(),
                user.getPassword(),
                isActive(user.getStatus()),
                isActive(user.getStatus()),
                isActive(user.getStatus()),
                isActive(user.getStatus()),
                getAuthority(user.getRoles())
        );
    }
}
