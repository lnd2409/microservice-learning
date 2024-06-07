package com.microuser.repository;

import com.microuser.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository
 *
 * @author DucLN
 * @version 01-00
 * @since 6/7/2024
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
