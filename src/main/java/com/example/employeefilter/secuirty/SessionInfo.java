package com.example.employeefilter.secuirty;

import com.example.employeefilter.entity.User;
import lombok.*;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Builder
@Component
public class SessionInfo {
    private User user;
}