package com.training.admissions.security;


import com.training.admissions.model.Permission;
import com.training.admissions.model.Status;
import com.training.admissions.model.Candidate;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@AllArgsConstructor
@Data
public class SecurityUser implements UserDetails {
    private final String username;
    private final String password;
    private final List<SimpleGrantedAuthority> authorities;
    private final boolean isActive;
    private  boolean isAdmin;




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
    public boolean isAdmin()
    {
        return authorities.contains(new SimpleGrantedAuthority("ADMIN"));
    }

    public static UserDetails getUserFromCandidate(Candidate candidate) {
        return new org.springframework.security.core.userdetails.User(
                candidate.getUsername(),
                candidate.getPassword(),
                candidate.getStatus().equals(Status.ACTIVE),
                candidate.getStatus().equals(Status.ACTIVE),
                candidate.getStatus().equals(Status.ACTIVE),
                candidate.getStatus().equals(Status.ACTIVE),
                candidate.getRole().getAuthorities());


    }
}
