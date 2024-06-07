package com.microuser.service;

import com.microuser.entity.UserEntity;

/**
 * IUserService
 *
 * @author DucLN
 * @version 01-00
 * @since 6/7/2024
 */
public interface IUserService {
    void register(UserEntity userEntity);
    String login(UserEntity userEntity);
}
