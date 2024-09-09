package com.corporateclient.service.client;

import com.corporateclient.dto.JwtRequest;
import com.corporateclient.dto.JwtResponse;
import com.corporateclient.dto.UserRegistrationRequest;
import com.corporateclient.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "USERMANAGEMENT", url = "http://localhost:9043")
public interface UsermanagementFeignClient {
    @PostMapping("/registerNewUser")
    public ResponseEntity<User> registerUser(@RequestBody UserRegistrationRequest userRequest);

    @PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest);
}
