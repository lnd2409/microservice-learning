package com.apigateway.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    @GetMapping("/get")
    public ResponseEntity test() {
        return new ResponseEntity<>("Test", HttpStatus.OK);
    }
}
