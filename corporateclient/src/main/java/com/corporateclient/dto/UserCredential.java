package com.corporateclient.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
public class UserCredential {
    private int id;
    private String userName;
    private String email;
    private String password;
    private Set<String> roles;


}
