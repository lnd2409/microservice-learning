package com.microtask.service.impl;

import com.microtask.dto.TaskCreateDto;
import com.microtask.entity.TaskEntity;
import com.microtask.repository.TaskRepository;
import com.microtask.service.ITaskService;
import com.microtask.utils.JwtUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * UserServiceImpl
 *
 * @author DucLN
 * @version 01-00
 * @since 6/7/2024
 */
@Service
@Transactional(readOnly = true)
@AllArgsConstructor
@Slf4j
public class TaskServiceImpl implements ITaskService {

    private final TaskRepository taskRepository;

    private final JwtUtils jwtUtils;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createTask(TaskCreateDto taskCreateDto) {
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setDescription(taskCreateDto.getDescription());
        taskEntity.setUserId(jwtUtils.extractUsername());
        taskRepository.save(new TaskEntity());
        log.info("Create task");
    }
}
