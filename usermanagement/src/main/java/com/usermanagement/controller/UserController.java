package com.usermanagement.controller;

import com.usermanagement.dto.UserRegistrationRequest;
import com.usermanagement.entity.Role;
import com.usermanagement.entity.User;
import com.usermanagement.repository.RoleRepository;
import com.usermanagement.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleRepository roleRepository;

    @PostConstruct
    public void initRoleAndUser() {
        userService.initRoleAndUser();
    }
    @PostMapping("/registerNewUser")
    public ResponseEntity<User> registerUser(@RequestBody UserRegistrationRequest userRequest) {
        User user = new User();
        user.setUserName(userRequest.getUserName());
        user.setUserPassword(userRequest.getUserPassword());
        user.setUserFirstName(userRequest.getUserFirstName());
        user.setUserLastName(userRequest.getUserLastName());
        User registeredUser = userService.registerNewUser(user, userRequest.getRole());
        return ResponseEntity.ok(registeredUser);
    }

   /* @PostMapping({"/registerNewUser"})
    public User registerNewUser(@RequestBody User user) {

        return userService.registerNewUser(user);
    }*/

    @GetMapping({"/forAdmin"})
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin(){
        return "This URL is only accessible to the admin";
    }

    @GetMapping({"/forUser"})
    @PreAuthorize("hasRole('User')")
    public String forUser(){
        return "This URL is only accessible to the user";
    }

}