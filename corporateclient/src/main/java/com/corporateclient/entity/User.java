package com.corporateclient.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Setter
@Getter
public class User {
    private String userName;
    private String userFirstName;
    private String userLastName;
    private String userPassword;

    private Set<Role> role;
}
