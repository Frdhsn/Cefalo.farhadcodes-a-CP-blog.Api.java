package com.springapi.farhadcodesacpblog.repository;

import com.springapi.farhadcodesacpblog.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    public Optional<Users> findByEmail(String email);
}
