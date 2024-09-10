package com.corporateclient.service.client;

import com.corporateclient.dto.UserCredential;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@FeignClient(name = "USERMANAGEMENTSERVICE", url = "http://localhost:9047")
public interface UsermanagementFeignClient {
    /*@PostMapping("/registerNewUser")
    public ResponseEntity<User> registerUser(@RequestBody UserRegistrationRequest userRequest);

    @PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest);*/
    @GetMapping("/validateToken")
    public String validateTokenId(@RequestHeader("Authorization") String token);

    @GetMapping("/fetch/{id}")
    public ResponseEntity<Optional<UserCredential>> fetchAccountDetails(@PathVariable int id);
}
