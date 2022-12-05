package com.example.spring.auth.dto;

import com.example.spring.member.domain.Member;
import com.example.spring.member.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {

    private String email;

    private String password;

    public Member toMember(PasswordEncoder passwordEncoder) {
        return Member.builder()
            .email(email)
            .password(passwordEncoder.encode(password))
            .role(Role.ROLE_USER)
            .build();
    }

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(email, password);
    }
}