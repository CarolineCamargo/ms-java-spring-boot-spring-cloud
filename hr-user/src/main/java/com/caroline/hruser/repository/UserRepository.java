package com.caroline.hruser.repository;

import com.caroline.hruser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
