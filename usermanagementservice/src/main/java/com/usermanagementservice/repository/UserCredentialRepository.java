package com.usermanagementservice.repository;



import com.usermanagementservice.entity.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserCredentialRepository extends JpaRepository<UserCredential,Integer> {
    Optional<UserCredential> findByUserName(String username);
    @Query(value="select * from user where id=?",nativeQuery = true)
    Optional<UserCredential> fetchUser(int id);


    boolean existsByRolesContaining(String roleAdmin);
}
