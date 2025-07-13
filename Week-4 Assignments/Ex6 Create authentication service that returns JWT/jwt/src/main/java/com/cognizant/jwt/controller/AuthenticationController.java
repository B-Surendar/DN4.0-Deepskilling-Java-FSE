package com.cognizant.jwt.controller;

import com.cognizant.jwt.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.Collections;
import java.util.Map;

@RestController
public class AuthenticationController {

    @GetMapping("/authenticate")
    public ResponseEntity<Map<String, String>> authenticate(@RequestHeader("Authorization") String authHeader) {
        // Step 1: Decode Basic Auth header
        String[] credentials = decodeBasicAuth(authHeader);
        String username = credentials[0];
        String password = credentials[1];

        // Step 2: Verify credentials
        if ("user".equals(username) && "pwd".equals(password)) {
            String token = JwtUtil.generateToken(username);
            System.out.println("Token generated: " + token);  // ✅ this will show in Eclipse Console
            return ResponseEntity.ok(Collections.singletonMap("token", token));
        }

        // Step 3: Unauthorized response
        return ResponseEntity.status(401).build();
    }

    // Helper method to decode Base64 Basic Auth
    private String[] decodeBasicAuth(String authHeader) {
        String base64Credentials = authHeader.substring("Basic ".length());
        byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);
        return new String(decodedBytes).split(":", 2);
    }
}
