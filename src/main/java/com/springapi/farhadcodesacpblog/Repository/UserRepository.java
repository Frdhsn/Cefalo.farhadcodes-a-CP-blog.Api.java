package com.springapi.farhadcodesacpblog.Repository;

import com.springapi.farhadcodesacpblog.Database.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
