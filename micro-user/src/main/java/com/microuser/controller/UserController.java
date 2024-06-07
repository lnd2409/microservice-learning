package com.microuser.controller;

import com.microuser.entity.UserEntity;
import com.microuser.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * UserController
 *
 * @author DucLN
 * @version 01-00
 * @since 6/6/2024
 */
@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final IUserService userService;


    @GetMapping("/get")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("Test", HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Map<String, String> userMap) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userMap.get("username"));
        userEntity.setPassword(userMap.get("password"));
        userService.register(userEntity);
        return new ResponseEntity<>("Register success", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> userMap) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userMap.get("username"));
        userEntity.setPassword(userMap.get("password"));
        String token = userService.login(userEntity);
        if (token.equals(HttpStatus.UNAUTHORIZED.getReasonPhrase())) {
            return new ResponseEntity<>("Invalid username or password!", HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(token, HttpStatus.OK);
    }
}
