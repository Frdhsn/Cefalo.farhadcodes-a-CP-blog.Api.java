package com.springapi.farhadcodesacpblog.repository;

import com.springapi.farhadcodesacpblog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
