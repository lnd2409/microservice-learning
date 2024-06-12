package com.microtask.service;

import com.microtask.dto.TaskCreateDto;

/**
 * IUserService
 *
 * @author DucLN
 * @version 01-00
 * @since 6/7/2024
 */
public interface ITaskService {
    void createTask(TaskCreateDto taskCreateDto);
}
