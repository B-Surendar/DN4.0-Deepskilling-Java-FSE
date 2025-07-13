package com.jwt.controller;

import com.jwt.util.JwtUtil;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.Principal;
import java.util.Map;

@RestController
public class AuthController {

    private final JwtUtil jwtUtil;
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(Principal principal) {
        LOGGER.info("Start authentication");
        String username = principal.getName();
        String token = jwtUtil.generateToken(username);
        LOGGER.info("Token generated");
        return Map.of("token", token);
    }
}
