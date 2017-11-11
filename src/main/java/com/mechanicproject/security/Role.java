package com.mechanicproject.security;

public enum Role {
    ROLE_USER("ROLE_USER"),
    ROLE_ADMIN("ROLE_ADMIN");

    String name;

    Role(String name){
        this.name = name;
    }
}
