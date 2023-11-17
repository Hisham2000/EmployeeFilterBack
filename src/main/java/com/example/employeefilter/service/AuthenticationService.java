package com.example.employeefilter.service;

import com.example.employeefilter.dto.AutenticationResponse;
import com.example.employeefilter.dto.LoginDTO;
import com.example.employeefilter.entity.User;
import com.example.employeefilter.exception.WrongUserNameOrPasswordException;
import com.example.employeefilter.repository.UserRepo;
import com.example.employeefilter.secuirty.JwtTokenUtilies;
import com.example.employeefilter.secuirty.SessionInfo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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
    @Autowired
    EmailService emailService;
    @Value("${forget.mail.password.length}")
    Integer passwordLength;

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

    public User resetPassword(String email) throws WrongUserNameOrPasswordException {
        Optional<User> user = userRepo.findByEmail(email);
        if(user.isPresent()){
            User getterUser = user.get();
            String newPassword = generatePassword();
            getterUser.setPassword(byBCryptPasswordEncoder.encode(newPassword));
            userRepo.save(getterUser);
            emailService.sendRestPasswordEmail(getterUser.getEmail(),
                    newPassword,
                    getterUser.getName(),
                    "Reset Password");
            return getterUser;
        }else {
            throw new WrongUserNameOrPasswordException("This email doesn't exist.");
        }
    }

    String generatePassword(){
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String special = "!@#$%^&*()_+-=[]{}|;:,.<>?";
        String validChars = upper + special + digits + lower;
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < passwordLength; i++) {
            int randomIndex = random.nextInt(validChars.length());
            password.append(validChars.charAt(randomIndex));
        }

        return password.toString();
    }

}
