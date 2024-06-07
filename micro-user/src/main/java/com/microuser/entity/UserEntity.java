package com.microuser.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * UserEntity
 *
 * @author DucLN
 * @version 01-00
 * @since 6/7/2024
 */
@Entity
@Getter
@Setter
@Table(name = "users")
public class UserEntity {
    @Id
    private String id;
    private String username;
    private String password;
}
