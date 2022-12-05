package com.example.spring.auth.controller;

import com.example.spring.auth.dto.AuthRequest;
import com.example.spring.auth.dto.TokenRequest;
import com.example.spring.auth.dto.TokenResponse;
import com.example.spring.auth.service.AuthService;
import com.example.spring.member.dto.MemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<MemberResponse> signup(
        @RequestBody AuthRequest authRequest
    ) {
        return ResponseEntity.ok(authService.signup(authRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(
        @RequestBody AuthRequest authRequest
    ) {
        return ResponseEntity.ok(authService.login(authRequest));
    }

    @PostMapping("/reissue")
    public ResponseEntity<TokenResponse> reissue(
        @RequestBody TokenRequest tokenRequest
    ) {
        return ResponseEntity.ok(authService.reissue(tokenRequest));
    }
}
