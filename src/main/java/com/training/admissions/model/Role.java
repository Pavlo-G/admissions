package com.training.admissions.model;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    USER(Set.of(Permission.CANDIDATES_READ))
    ,ADMIN(Set.of(Permission.CANDIDATES_WRITE,Permission.CANDIDATES_READ));



    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions= permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }


    public  Set<SimpleGrantedAuthority> getAuthorities(){
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermissionName()))
                .collect(Collectors.toSet());
    }
}
