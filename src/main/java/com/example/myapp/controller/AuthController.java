package com.example.myapp.controller;

import com.example.myapp.model.request.JwtRequest;
import com.example.myapp.model.response.JwtResponse;
import com.example.myapp.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/authenticate")
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/")
    public ResponseEntity<JwtResponse> authenticate(@RequestBody JwtRequest jwtRequest) {
        return ResponseEntity.ok(authenticationService.authenticate(jwtRequest));
    }

    @GetMapping("/secured-api")
    public String home() {
        return "Your jwt token works";
    }

    @PostMapping("/register")
    public ResponseEntity<JwtResponse> register(
            @RequestBody JwtRequest request
    ) {
        return ResponseEntity.ok(authenticationService.register(request));
    }
}
