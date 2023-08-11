package com.example.myapp.service;

import com.example.myapp.entity.UserEntity;
import com.example.myapp.model.request.JwtRequest;
import com.example.myapp.model.response.JwtResponse;
import com.example.myapp.repository.UserRepository;
import com.example.myapp.utility.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final AuthenticationManager authenticationManager;

    private final UserRepository repository;

    private final JwtUtil jwtUtil;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthenticationService(AuthenticationManager authenticationManager, UserRepository repository, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.repository = repository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    public JwtResponse authenticate(JwtRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = repository.findFirstByEmail(request.getEmail());
        var jwtToken = jwtUtil.generateToken(user);
        return JwtResponse.builder()
                .accessToken(jwtToken)
                .build();
    }

    public JwtResponse register(JwtRequest request) {
        var user = UserEntity.builder()
                .firstName(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();
        var savedUser = repository.save(user);
        var jwtToken = jwtUtil.generateToken(user);
        return JwtResponse.builder()
                .accessToken(jwtToken)
                .build();
    }
}
