package com.microuser.service.impl;

import com.microuser.entity.UserEntity;
import com.microuser.repository.UserRepository;
import com.microuser.service.IUserService;
import com.microuser.utils.JwtUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

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
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    private final JwtUtils jwtUtils;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void register(UserEntity userEntity) {
        UUID uuid = UUID.randomUUID();
        userEntity.setId(uuid.toString());
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userRepository.save(userEntity);
    }

    @Override
    public String login(UserEntity user) {
        UserEntity foundUser = userRepository.findByUsername(user.getUsername());
        if (foundUser != null && passwordEncoder.matches(user.getPassword(), foundUser.getPassword())) {
            return jwtUtils.generateToken(user.getUsername());
        }
        log.error("[LOGIN] error with username {}", user.getUsername());
        return HttpStatus.UNAUTHORIZED.getReasonPhrase();
    }
}
