package com.example.employeefilter.exception;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponse {
    private Boolean success = Boolean.FALSE;
    private Integer code;
    private String message;
}