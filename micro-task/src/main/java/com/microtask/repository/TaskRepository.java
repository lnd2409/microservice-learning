package com.microtask.repository;

import com.microtask.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TaskRepositoryRepository
 *
 * @author DucLN
 * @version 01-00
 * @since 6/12/2024
 */
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}
