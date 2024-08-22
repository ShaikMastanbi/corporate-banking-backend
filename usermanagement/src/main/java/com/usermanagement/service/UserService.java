package com.usermanagement.service;

import com.usermanagement.entity.Role;
import com.usermanagement.entity.User;
import com.usermanagement.repository.RoleRepository;
import com.usermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserRepository userDao;

    @Autowired
    private RoleRepository roleDao;
    @Autowired
    private PasswordEncoder passwordEncoder;


   /* public User registerNewUser(User user) {

        Role role = roleDao.findById("User").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRole(userRoles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));

        return userDao.save(user);
    }*/

   /* public void initRoleAndUser(){
        Role adminRole=new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        roleDao.save(userRole);

         User adminUser = new User();
        adminUser.setUserName("admin123");
        adminUser.setUserPassword(getEncodedPassword("admin@pass"));
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);

        *//*User user = new User();
        user.setUserName("raj123");
        user.setUserPassword(getEncodedPassword("raj@123"));
        user.setUserFirstName("raj");
        user.setUserLastName("sharma");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setRole(userRoles);
        userDao.save(user);
*//*
    }*/

    public User registerNewUser(User user, String roleName) {
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));
        //user.setEnabled(true);
        Set<Role> roles = new HashSet<>();
        Role role = roleDao.findByRoleName(roleName);
        if (role != null) {
            roles.add(role);
        } else {
            role = new Role();
            role.setRoleName(roleName);
            role.setRoleDescription(roleName + " role");
            roleDao.save(role);
            roles.add(role);
        }
        user.setRole(roles);
        return userDao.save(user);
    }



    public void initRoleAndUser() {
        // Initialize roles
        createRoleIfNotFound("Admin", "Admin role");
        createRoleIfNotFound("User", "Default role for newly created record");
        createRoleIfNotFound("LoanOfficer", "Role for loan officers");
        createRoleIfNotFound("CorporateClient", "Role for corporate clients");
        createRoleIfNotFound("LoanOfficerManager", "Role for loan officer managers");

        // Initialize admin user
        if (userDao.findByUserName("admin123") == null) {
            User adminUser = new User();
            adminUser.setUserName("admin123");
            adminUser.setUserPassword(getEncodedPassword("admin@pass"));
            adminUser.setUserFirstName("admin");
            adminUser.setUserLastName("admin");
            //adminUser.setEnabled(true);
            Set<Role> adminRoles = new HashSet<>();
            adminRoles.add(roleDao.findByRoleName("Admin"));
            adminUser.setRole(adminRoles);
            userDao.save(adminUser);
        }

        if (userDao.findByUserName("loanManager123") == null) {
            User loanManagerUser = new User();
            loanManagerUser.setUserName("loanManager123");
            loanManagerUser.setUserPassword(getEncodedPassword("loanManager@pass"));
            loanManagerUser.setUserFirstName("Loan");
            loanManagerUser.setUserLastName("Manager");
            //loanManagerUser.setEnabled(true);
            Set<Role> loanManagerRoles = new HashSet<>();
            loanManagerRoles.add(roleDao.findByRoleName("LoanOfficerManager"));
            loanManagerUser.setRole(loanManagerRoles);
            userDao.save(loanManagerUser);
        }
    }

    private void createRoleIfNotFound(String roleName, String roleDescription) {
        if (roleDao.findByRoleName(roleName) == null) {
            Role role = new Role();
            role.setRoleName(roleName);
            role.setRoleDescription(roleDescription);
            roleDao.save(role);
        }
    }


    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }


}

