package com.microtask.controller;

import com.microtask.dto.TaskCreateDto;
import com.microtask.service.ITaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 *
 * @author DucLN
 * @version 01-00
 * @since 6/6/2024
 */
@RestController
@RequestMapping("/task")
@AllArgsConstructor
public class TaskController {

    private final ITaskService taskService;

    @PostMapping("/create")
    public ResponseEntity<String> createTask(@RequestBody TaskCreateDto taskCreateDto) {
        taskService.createTask();
        return ResponseEntity.ok("Create task success");
    }
}
