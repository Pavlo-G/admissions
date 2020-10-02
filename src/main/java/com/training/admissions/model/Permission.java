package com.training.admissions.model;

public enum Permission {
    CANDIDATES_READ("candidates:read"),
    CANDIDATES_WRITE("candidates:write"),
    ADMINS_EDIT("admins:edit");


    private final String permissionName;

    Permission(String permissionName){
        this.permissionName = permissionName;
    }

    public String getPermissionName() {
        return permissionName;
    }
}
