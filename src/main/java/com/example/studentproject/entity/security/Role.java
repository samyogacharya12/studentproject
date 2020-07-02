package com.example.studentproject.entity.security;

import com.example.studentproject.abstractclasses.AbstractEntity;
import com.example.studentproject.enumconstant.Privilege;
import com.example.studentproject.enumconstant.Status;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Role extends AbstractEntity {

    private String name;

    private Status status;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UserRole> userRoles = new HashSet<>();

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Privilege> privilege;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public Set<Privilege> getPermissionSet() {
        return privilege;
    }

    public void setPermissionSet(Set<Privilege> privilegeSet) {
        this.privilege = privilegeSet;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
