package com.example.employeefilter.dto;

import com.example.employeefilter.entity.User;
import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Builder
public class AutenticationResponse {
    private String token;
    private User user;
}