package com.kakofo.kakofoservice.auth.repository;

import com.kakofo.kakofoservice.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByUsernameOrEmail(String username, String email);

    @Query("from User u where u.id=:id")
    User findUserById(@Param(value = "id") Long id);

    @Query("from User u where u.id<>:id and u.username=:username")
    List<User> checkExistingUser(@Param(value = "id") Long id, @Param(value = "username") String username);

    boolean existsByUsername(String username);

    User findByPhone(String phone);

    User findByEmail(String email);

}
