package com.example.v6.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

public class AppUser implements UserDetails {

    private final String userName;
    private final String password;
    private final Set<? extends GrantedAuthority> grantedAuthorities;

    public AppUser(String userName,
                   String password,
                   Set<? extends GrantedAuthority> grantedAuthorities) {
        this.userName = userName;
        this.password = password;
        this.grantedAuthorities = grantedAuthorities;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
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
}
