package com.microtask.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * TaskEntity
 *
 * @author DucLN
 * @version 01-00
 * @since 6/12/2024
 */
@Entity
@Getter
@Setter
@Table(name = "task")
public class TaskEntity {
    @Id
    private String id;
    private String description;
    @Column(name = "user_id")
    private String userId;
}
