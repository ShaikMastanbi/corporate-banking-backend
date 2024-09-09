package com.corporateclient.dto;

import com.corporateclient.entity.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JwtResponse {
    private User user;
    private String jwtToken;
}
