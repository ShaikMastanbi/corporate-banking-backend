package com.corporateclient.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JwtRequest {
    private String userName;
    private String userPassword;
}
