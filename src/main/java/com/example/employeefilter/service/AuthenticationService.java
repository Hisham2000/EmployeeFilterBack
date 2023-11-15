package com.example.employeefilter.service;

import com.example.employeefilter.dto.AutenticationResponse;
import com.example.employeefilter.dto.LoginDTO;
import com.example.employeefilter.entity.User;
import com.example.employeefilter.repository.UserRepo;
import com.example.employeefilter.secuirty.JwtTokenUtilies;
import com.example.employeefilter.secuirty.SessionInfo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    @Autowired
    UserRepo userRepo;
    @Autowired
    BCryptPasswordEncoder byBCryptPasswordEncoder;
    @Autowired
    JwtTokenUtilies jwtTokenUtilies;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    SessionInfo sessionInfo;

    public AutenticationResponse login(LoginDTO loginDTO) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getEmail(),
                        loginDTO.getPassword()
                )
        );
        User user = userRepo.findByEmail(loginDTO.getEmail()).orElseThrow();
        String token = jwtTokenUtilies.generateToken(user);
        return AutenticationResponse.builder()
                .token(token)
                .user(user)
                .build();
    }

    public Map<String, String> logOut(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> returnedResponse = new HashMap<>();
        // Custom logout logic, if needed
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            returnedResponse.put("message", "loggedOut Successfully");
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return returnedResponse;
    }
}
