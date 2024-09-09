package com.usermanagementservice.controller;



import com.usermanagementservice.dto.ApiResponse;
import com.usermanagementservice.dto.AuthRequest;
import com.usermanagementservice.dto.ResponseDto;
import com.usermanagementservice.entity.UserCredential;
import com.usermanagementservice.service.AuthService;
import com.usermanagementservice.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
   /* @Autowired
    private AuthService service;
    @Autowired
    private JwtService jwtservice;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<ResponseDto> addNewUser(@RequestBody UserCredential user) {

       String s= service.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto("201", "user created successfully 🎉🎉"));

    }


    @PostMapping("/token")
    public ResponseEntity<ApiResponse> getToken(@RequestBody AuthRequest authRequest) {
        try {
            Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
            if (authenticate.isAuthenticated()) {
                String token = service.generateToken(authRequest.getUsername());
                return ResponseEntity.ok(new ApiResponse(token, true));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(new ApiResponse("Invalid credentials", false));
            }
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new ApiResponse("Invalid credentials", false));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse("An error occurred: " + e.getMessage(), false));
        }
    }
    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
         service.validateToken(token);
        return "Token is valid";
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<Optional<UserCredential>> fetchAccountDetails(@PathVariable int id) {
        Optional<UserCredential> userCredential = service.getUserDetails(id);
        return ResponseEntity.status(HttpStatus.OK).body(userCredential);
    }

    @GetMapping("/validateToken")
    public String validateTokenId(@RequestHeader("Authorization") String token) {
        String userId = jwtservice.validateTokenAndGetUserId(token, "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437");

        if (userId != null) {
         //   return "Token is valid for user name: " + userId;
            return userId;
        } else {
            return "Invalid token";
        }
    }
*/
   @Autowired
   private AuthService service;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<ResponseDto> addNewUser(@RequestBody UserCredential user) {
        String s = service.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto("201", "user created successfully 🎉🎉"));
    }
    @PostMapping("/token")
    public ResponseEntity<ApiResponse> getToken(@RequestBody AuthRequest authRequest) {
        try {
            System.out.println("Attempting to authenticate user: " + authRequest.getUsername());

            Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

            if (authenticate.isAuthenticated()) {
                String token = service.generateToken(authRequest.getUsername());
                System.out.println("Authentication successful for user: " + authRequest.getUsername());
                return ResponseEntity.ok(new ApiResponse(token, true));
            } else {
                System.out.println("Authentication failed for user: " + authRequest.getUsername());
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(new ApiResponse("Invalid credentials", false));
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new ApiResponse("Invalid credentials", false));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse("An error occurred: " + e.getMessage(), false));
        }
    }
    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        service.validateToken(token);
        return "Token is valid";
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<Optional<UserCredential>> fetchAccountDetails(@PathVariable int id) {
        Optional<UserCredential> userCredential = service.getUserDetails(id);
        return ResponseEntity.status(HttpStatus.OK).body(userCredential);
    }

    @GetMapping("/validateToken")
    public String validateTokenId(@RequestHeader("Authorization") String token) {
        String userId = jwtService.validateTokenAndGetUserId(token);
        return userId != null ? userId : "Invalid token";
    }

}
