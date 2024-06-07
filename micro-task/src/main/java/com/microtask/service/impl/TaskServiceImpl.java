package com.microtask.service.impl;

import com.microtask.service.ITaskService;
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
public class TaskServiceImpl implements ITaskService {}
