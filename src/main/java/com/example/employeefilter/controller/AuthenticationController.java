package com.example.employeefilter.controller;

import com.example.employeefilter.dto.AutenticationResponse;
import com.example.employeefilter.dto.LoginDTO;
import com.example.employeefilter.secuirty.JwtTokenUtilies;
import com.example.employeefilter.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin()
public class AuthenticationController {
    @Autowired
    AuthenticationService authenticationService;
    @Autowired
    JwtTokenUtilies jwtTokenUtilies;
    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<AutenticationResponse> login(@RequestBody LoginDTO loginDTO) {
        return ResponseEntity.ok(authenticationService.login(loginDTO));
    }
}
