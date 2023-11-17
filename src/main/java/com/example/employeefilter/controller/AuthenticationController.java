package com.example.employeefilter.controller;

import com.example.employeefilter.dto.AutenticationResponse;
import com.example.employeefilter.dto.LoginDTO;
import com.example.employeefilter.exception.WrongUserNameOrPasswordException;
import com.example.employeefilter.secuirty.JwtTokenUtilies;
import com.example.employeefilter.service.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

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

    @GetMapping("/logoutV2")
    public ResponseEntity logout(HttpServletRequest request, HttpServletResponse response) {
        return ResponseEntity.ok(authenticationService.logOut(request, response));
    }

    @PostMapping("/reset_password")
    public ResponseEntity resetPassword(@RequestBody HashMap email) throws WrongUserNameOrPasswordException {
        return ResponseEntity.ok(authenticationService.resetPassword(email.get("email").toString()));
    }
}
